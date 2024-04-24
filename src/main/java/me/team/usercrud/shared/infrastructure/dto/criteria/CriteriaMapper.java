package me.team.usercrud.shared.infrastructure.dto.criteria;

import me.team.usercrud.shared.domain.criteria.*;

public class CriteriaMapper {
    public static Criteria from(CriteriaPrimitive criteriaPrimitive) {
        var criteria = Criteria.none();

        criteria.setFilters(new Filters(criteriaPrimitive.getFilters().stream().map(CriteriaMapper::from).toList()));

        if (criteriaPrimitive.hasOrder()) {
            criteria.setOrder(CriteriaMapper.from(criteriaPrimitive.getOrder()));
        }

        return criteria;
    }

    public static Filter from(FilterPrimitive filterPrimitive) {
        return Filter.from(
            filterPrimitive.getField(),
            FilterOperator.valueOf(filterPrimitive.getOperator()),
            filterPrimitive.getValue()
        );
    }

    public static Order from(OrderPrimitive orderPrimitive) {
        return new Order(new OrderBy(orderPrimitive.getOrderBy()), OrderType.valueOf(orderPrimitive.getOrderType()));
    }
}
