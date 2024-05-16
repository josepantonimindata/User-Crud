package me.team.usercrud.shared.infrastructure.controllers.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.infrastructure.controllers.criteria.OrderPrimitive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderPrimitive implements Mapper<Order, OrderPrimitive> {
    @NonNull
    @Override
    public OrderPrimitive map(@NonNull Order order) {
        return new OrderPrimitive(
            order.orderBy().value(),
            order.orderType().toString()
        );
    }
}
