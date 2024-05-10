package me.team.usercrud.shared.infrastructure.controllers.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.infrastructure.controllers.criteria.CriteriaPrimitive;
import me.team.usercrud.shared.infrastructure.controllers.criteria.FilterPrimitive;
import me.team.usercrud.shared.infrastructure.controllers.criteria.OrderPrimitive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CriteriaPrimitiveToCriteria implements Mapper<CriteriaPrimitive, Criteria> {
    private final Mapper<FilterPrimitive, Filter> filterMapper;
    private final Mapper<OrderPrimitive, Order> orderMapper;
    
    public CriteriaPrimitiveToCriteria(
        Mapper<FilterPrimitive, Filter> filterMapper,
        Mapper<OrderPrimitive, Order> orderMapper
    ) {
        this.filterMapper = filterMapper;
        this.orderMapper = orderMapper;
    }
    
    @NonNull
    public Criteria map(@NonNull CriteriaPrimitive criteriaPrimitive) {
        var criteria = Criteria.none();
        
        var order = criteriaPrimitive.getOrder();
        if (order != null && order.hasOrder()) {
            criteria.order(orderMapper.map(order));
        }
        
        var filters = criteriaPrimitive.getFilters();
        if (filters != null) {
            criteria.filters(filters.stream().map(filterMapper::map).toList());
        }
        
        return criteria;
    }
}
