package me.team.usercrud.shared.infrastructure.dto.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.infrastructure.dto.criteria.OrderPrimitive;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderPrimitiveMapper implements Mapper<Order, OrderPrimitive> {

    private final Mapper<OrderPrimitive, Order> mapper;

    public OrderToOrderPrimitiveMapper(Mapper<OrderPrimitive, Order> mapper) {
        this.mapper = mapper;
    }

    @Override
    public OrderPrimitive from(Order fromType) {
        return mapper.to(fromType);
    }

    @Override
    public Order to(OrderPrimitive toType) {
        return mapper.from(toType);
    }
}