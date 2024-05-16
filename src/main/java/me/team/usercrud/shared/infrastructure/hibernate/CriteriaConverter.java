package me.team.usercrud.shared.infrastructure.hibernate;

import jakarta.persistence.criteria.*;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.domain.criteria.FilterOperator;
import org.springframework.lang.NonNull;

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
    
    @NonNull
    public CriteriaQuery<T> convert(@NonNull Criteria criteria, @NonNull Class<T> aggregateClass) {
        CriteriaQuery<T> criteriaQuery = builder.createQuery(aggregateClass);
        Root<T> root = criteriaQuery.from(aggregateClass);
        
        criteria.filters().ifPresent(filters -> criteriaQuery.where(formatPredicates(filters, root)));
        
        criteria.order().ifPresent(order -> {
            Path<Object> orderBy = root.get(order.orderBy().value());
            Order hibernateOrder = order.orderType().isAsc() ? builder.asc(orderBy) : builder.desc(orderBy);
            
            criteriaQuery.orderBy(hibernateOrder);
        });
        
        return criteriaQuery;
    }
    
    public <C> void apply(
        @NonNull Criteria criteria,
        @NonNull Class<T> aggregateClass,
        @NonNull CriteriaQuery<C> query
    ) {
        Root<T> root = query.from(aggregateClass);
        criteria.filters().ifPresent(filters -> query.where(formatPredicates(filters, root)));
    }
    
    @NonNull
    private Predicate[] formatPredicates(List<Filter> filters, Root<T> root) {
        List<Predicate> predicates = filters.stream().map(filter -> formatPredicate(filter, root)).toList();
        
        Predicate[] predicatesArray = new Predicate[predicates.size()];
        predicatesArray = predicates.toArray(predicatesArray);
        
        return predicatesArray;
    }
    
    @NonNull
    private Predicate formatPredicate(@NonNull Filter filter, @NonNull Root<T> root) {
        BiFunction<Filter, Root<T>, Predicate> transformer = predicateTransformers.get(filter.operator());
        
        return transformer.apply(filter, root);
    }
    
    @NonNull
    private Predicate equalsPredicateTransformer(@NonNull Filter filter, @NonNull Root<T> root) {
        return builder.equal(root.get(filter.field().value()), filter.value().value());
    }
    
    @NonNull
    private Predicate notEqualsPredicateTransformer(@NonNull Filter filter, @NonNull Root<T> root) {
        return builder.notEqual(root.get(filter.field().value()), filter.value().value());
    }
    
    @NonNull
    private Predicate greaterThanPredicateTransformer(@NonNull Filter filter, @NonNull Root<T> root) {
        return builder.greaterThan(root.get(filter.field().value()), filter.value().value());
    }
    
    @NonNull
    private Predicate lowerThanPredicateTransformer(@NonNull Filter filter, @NonNull Root<T> root) {
        return builder.lessThan(root.get(filter.field().value()), filter.value().value());
    }
    
    @NonNull
    private Predicate containsPredicateTransformer(@NonNull Filter filter, @NonNull Root<T> root) {
        return builder.like(root.get(filter.field().value()), String.format("%%%s%%", filter.value().value()));
    }
    
    @NonNull
    private Predicate notContainsPredicateTransformer(@NonNull Filter filter, @NonNull Root<T> root) {
        return builder.notLike(root.get(filter.field().value()), String.format("%%%s%%", filter.value().value()));
    }
}
