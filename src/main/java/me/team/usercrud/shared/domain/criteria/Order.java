package me.team.usercrud.shared.domain.criteria;

import java.util.Objects;

public class Order {
    private OrderBy orderBy;
    private OrderType orderType;

    public Order(OrderBy orderBy, OrderType orderType) {
        this.orderBy = orderBy;
        this.orderType = orderType;
    }

    public static Order none() {
        return new Order(new OrderBy(""), OrderType.NONE);
    }

    public static Order desc(String orderBy) {
        return new Order(new OrderBy(orderBy), OrderType.DESC);
    }

    public static Order asc(String orderBy) {
        return new Order(new OrderBy(orderBy), OrderType.ASC);
    }

    public boolean hasOrder() {
        return !orderType.isNone();
    }

    public OrderBy orderBy()                   {return this.orderBy;}

    public void orderBy(OrderBy orderBy)       {this.orderBy = orderBy;}

    public OrderType orderType()               {return this.orderType;}

    public void orderType(OrderType orderType) {this.orderType = orderType;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderBy, order.orderBy) && orderType == order.orderType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderBy, orderType);
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderBy=" + orderBy +
            ", orderType=" + orderType +
            '}';
    }
}


