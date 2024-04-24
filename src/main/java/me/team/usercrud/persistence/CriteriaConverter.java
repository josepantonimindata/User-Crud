package me.team.usercrud.persistence;

import jakarta.persistence.criteria.*;
import me.team.usercrud.domain.criteria.Criteria;
import me.team.usercrud.domain.criteria.Filter;
import me.team.usercrud.domain.criteria.FilterOperator;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;


public final class CriteriaConverter<T> {
    private final CriteriaBuilder builder;
    private final HashMap<FilterOperator, BiFunction<Filter, Root<T>, Predicate>> predicateTransformers = new HashMap<>() {{
        put(FilterOperator.EQUAL, CriteriaConverter.this::equalsPredicateTransformer);
        put(FilterOperator.NOT_EQUAL, CriteriaConverter.this::notEqualsPredicateTransformer);
        put(FilterOperator.GT, CriteriaConverter.this::greaterThanPredicateTransformer);
        put(FilterOperator.LT, CriteriaConverter.this::lowerThanPredicateTransformer);
        put(FilterOperator.CONTAINS, CriteriaConverter.this::containsPredicateTransformer);
        put(FilterOperator.NOT_CONTAINS, CriteriaConverter.this::notContainsPredicateTransformer);
    }};

    public CriteriaConverter(CriteriaBuilder builder) {
        this.builder = builder;
    }

    public CriteriaQuery<T> convert(Criteria criteria, Class<T> aggregateClass) {
        CriteriaQuery<T> criteriaQuery = builder.createQuery(aggregateClass);
        Root<T> root = criteriaQuery.from(aggregateClass);

        criteriaQuery.where(formatPredicates(criteria.getFilters().getFilters(), root));

        if (criteria.getOrder().hasOrder()) {
            Path<Object> orderBy = root.get(criteria.getOrder().getOrderBy().getValue());
            Order order = criteria.getOrder().getOrderType().isAsc() ? builder.asc(orderBy) : builder.desc(orderBy);

            criteriaQuery.orderBy(order);
        }

        return criteriaQuery;
    }

    private Predicate[] formatPredicates(List<Filter> filters, Root<T> root) {
        List<Predicate> predicates = filters.stream().map(filter -> formatPredicate(filter, root)).toList();

        Predicate[] predicatesArray = new Predicate[predicates.size()];
        predicatesArray = predicates.toArray(predicatesArray);

        return predicatesArray;
    }

    private Predicate formatPredicate(Filter filter, Root<T> root) {
        BiFunction<Filter, Root<T>, Predicate> transformer = predicateTransformers.get(filter.getOperator());

        return transformer.apply(filter, root);
    }

    private Predicate equalsPredicateTransformer(Filter filter, Root<T> root) {
        return builder.equal(root.get(filter.getField().getValue()), filter.getValue().getValue());
    }

    private Predicate notEqualsPredicateTransformer(Filter filter, Root<T> root) {
        return builder.notEqual(root.get(filter.getField().getValue()), filter.getValue().getValue());
    }

    private Predicate greaterThanPredicateTransformer(Filter filter, Root<T> root) {
        return builder.greaterThan(root.get(filter.getField().getValue()), filter.getValue().getValue());
    }

    private Predicate lowerThanPredicateTransformer(Filter filter, Root<T> root) {
        return builder.lessThan(root.get(filter.getField().getValue()), filter.getValue().getValue());
    }

    private Predicate containsPredicateTransformer(Filter filter, Root<T> root) {
        return builder.like(root.get(filter.getField().getValue()), String.format("%%%s%%", filter.getValue().getValue()));
    }

    private Predicate notContainsPredicateTransformer(Filter filter, Root<T> root) {
        return builder.notLike(root.get(filter.getField().getValue()), String.format("%%%s%%", filter.getValue().getValue()));
    }
}
