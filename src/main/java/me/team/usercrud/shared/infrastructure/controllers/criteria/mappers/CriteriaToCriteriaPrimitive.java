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
public class CriteriaToCriteriaPrimitive implements Mapper<Criteria, CriteriaPrimitive> {
    private final Mapper<Filter, FilterPrimitive> filterMapper;
    private final Mapper<Order, OrderPrimitive> orderMapper;
    
    public CriteriaToCriteriaPrimitive(
        Mapper<Filter, FilterPrimitive> filterMapper,
        Mapper<Order, OrderPrimitive> orderMapper
    ) {
        this.filterMapper = filterMapper;
        this.orderMapper = orderMapper;
    }
    
    @NonNull
    @Override
    public CriteriaPrimitive map(@NonNull Criteria criteria) {
        return new CriteriaPrimitive(
            ListUtils.map(criteria.filters(), filterMapper::map).orElse(null),
            criteria.order().map(orderMapper::map).orElse(null)
        );
    }
}
