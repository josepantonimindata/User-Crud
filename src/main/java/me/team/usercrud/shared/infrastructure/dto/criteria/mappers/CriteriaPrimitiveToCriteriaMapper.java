package me.team.usercrud.shared.infrastructure.dto.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.Filter;
import me.team.usercrud.shared.domain.criteria.Filters;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.infrastructure.dto.criteria.CriteriaPrimitive;
import me.team.usercrud.shared.infrastructure.dto.criteria.FilterPrimitive;
import me.team.usercrud.shared.infrastructure.dto.criteria.OrderPrimitive;
import org.springframework.stereotype.Component;

@Component
public class CriteriaPrimitiveToCriteriaMapper implements Mapper<CriteriaPrimitive, Criteria> {
    private final Mapper<FilterPrimitive, Filter> filterMapper;
    private final Mapper<OrderPrimitive, Order> orderMapper;

    public CriteriaPrimitiveToCriteriaMapper(Mapper<FilterPrimitive, Filter> filterMapper, Mapper<OrderPrimitive, Order> orderMapper) {
        this.filterMapper = filterMapper;
        this.orderMapper = orderMapper;
    }

    public Criteria from(CriteriaPrimitive criteriaPrimitive) {
        var criteria = Criteria.none();

        criteria.filters(new Filters(criteriaPrimitive.getFilters().stream().map(filterMapper::from).toList()));

        if (criteriaPrimitive.hasOrder()) {
            criteria.order(orderMapper.from(criteriaPrimitive.getOrder()));
        }

        return criteria;
    }

    @Override
    public CriteriaPrimitive to(Criteria criteria) {
        return new CriteriaPrimitive(
            criteria.filters().filters().stream().map(filterMapper::to).toList(),
            orderMapper.to(criteria.order())
        );
    }
}
