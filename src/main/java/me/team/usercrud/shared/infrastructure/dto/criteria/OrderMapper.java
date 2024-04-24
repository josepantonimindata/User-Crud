package me.team.usercrud.shared.infrastructure.dto.criteria;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.domain.criteria.OrderBy;
import me.team.usercrud.shared.domain.criteria.OrderType;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<OrderPrimitive, Order> {

    @Override
    public Order from(OrderPrimitive orderPrimitive) {
        return new Order(new OrderBy(orderPrimitive.getOrderBy()), OrderType.valueOf(orderPrimitive.getOrderType()));
    }

    @Override
    public OrderPrimitive to(Order order) {
        return new OrderPrimitive(
            order.getOrderBy().value(),
            order.getOrderType().toString()
        );
    }
}
