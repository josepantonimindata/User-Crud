package me.team.usercrud.shared.infrastructure.controllers.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.domain.services.ListUtils;
import me.team.usercrud.shared.infrastructure.controllers.criteria.CriteriaPrimitive;
import me.team.usercrud.shared.infrastructure.controllers.criteria.FilterPrimitive;
import me.team.usercrud.shared.infrastructure.controllers.criteria.OrderPrimitive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CriteriaPrimitiveToCriteriaMapper implements Mapper<CriteriaPrimitive, Criteria> {
    private final Mapper<FilterPrimitive, Filter> filterMapper;
    private final Mapper<OrderPrimitive, Order> orderMapper;
    
    public CriteriaPrimitiveToCriteriaMapper(
        Mapper<FilterPrimitive, Filter> filterMapper,
        Mapper<OrderPrimitive, Order> orderMapper
    ) {
        this.filterMapper = filterMapper;
        this.orderMapper = orderMapper;
    }
    
    @NonNull
    public Criteria map(@NonNull CriteriaPrimitive criteriaPrimitive) {
        var criteria = Criteria.none();
        
        criteriaPrimitive.filters()
            .map(filters -> filters.stream().map(filterMapper::map).toList())
            .ifPresent(criteria::filters);
        
        criteriaPrimitive.order().map(orderMapper::map).ifPresent(criteria::order);
        
        return criteria;
    }
}
