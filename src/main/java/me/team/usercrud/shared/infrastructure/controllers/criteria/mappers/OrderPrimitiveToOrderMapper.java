package me.team.usercrud.shared.infrastructure.controllers.criteria.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.domain.criteria.OrderBy;
import me.team.usercrud.shared.domain.criteria.OrderType;
import me.team.usercrud.shared.infrastructure.controllers.criteria.OrderPrimitive;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class OrderPrimitiveToOrderMapper implements Mapper<OrderPrimitive, Order> {
    @NonNull
    @Override
    public Order map(@NonNull OrderPrimitive orderPrimitive) {
        return new Order(new OrderBy(orderPrimitive.getOrderBy()), OrderType.valueOf(orderPrimitive.getOrderType()));
    }
}
