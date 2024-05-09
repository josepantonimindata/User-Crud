package me.team.usercrud.shared.infrastructure.dto.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.domain.criteria.OrderBy;
import me.team.usercrud.shared.domain.criteria.OrderType;
import me.team.usercrud.shared.infrastructure.dto.criteria.OrderPrimitive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class OrderPrimitiveToOrderMapper implements Mapper<OrderPrimitive, Order> {

    @Override
    public Order from(@NonNull OrderPrimitive orderPrimitive) {
        return new Order(new OrderBy(orderPrimitive.getOrderBy()), OrderType.valueOf(orderPrimitive.getOrderType()));
    }

    @Override
    public OrderPrimitive to(@NonNull Order order) {
        return new OrderPrimitive(
            order.orderBy().value(),
            order.orderType().toString()
        );
    }
}
