package me.team.usercrud.shared.infrastructure.hibernate;

import jakarta.persistence.criteria.*;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.domain.criteria.FilterOperator;

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

        criteriaQuery.where(formatPredicates(criteria.filters().filters(), root));

        if (criteria.order().hasOrder()) {
            Path<Object> orderBy = root.get(criteria.order().orderBy().value());
            Order order = criteria.order().orderType().isAsc() ? builder.asc(orderBy) : builder.desc(orderBy);

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
        BiFunction<Filter, Root<T>, Predicate> transformer = predicateTransformers.get(filter.operator());

        return transformer.apply(filter, root);
    }

    private Predicate equalsPredicateTransformer(Filter filter, Root<T> root) {
        return builder.equal(root.get(filter.field().value()), filter.value().value());
    }

    private Predicate notEqualsPredicateTransformer(Filter filter, Root<T> root) {
        return builder.notEqual(root.get(filter.field().value()), filter.value().value());
    }

    private Predicate greaterThanPredicateTransformer(Filter filter, Root<T> root) {
        return builder.greaterThan(root.get(filter.field().value()), filter.value().value());
    }

    private Predicate lowerThanPredicateTransformer(Filter filter, Root<T> root) {
        return builder.lessThan(root.get(filter.field().value()), filter.value().value());
    }

    private Predicate containsPredicateTransformer(Filter filter, Root<T> root) {
        return builder.like(root.get(filter.field().value()), String.format("%%%s%%", filter.value().value()));
    }

    private Predicate notContainsPredicateTransformer(Filter filter, Root<T> root) {
        return builder.notLike(root.get(filter.field().value()), String.format("%%%s%%", filter.value().value()));
    }
}
