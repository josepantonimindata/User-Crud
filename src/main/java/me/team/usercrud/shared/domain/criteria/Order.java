package me.team.usercrud.shared.domain.criteria;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class Order {
    @NonNull
    private OrderBy orderBy;
    @NonNull
    private OrderType orderType;
    
    public Order(@NonNull OrderBy orderBy, @NonNull OrderType orderType) {
        this.orderBy = orderBy;
        this.orderType = orderType;
    }
    
    @NonNull
    public static Order desc(@NonNull String orderBy) {
        return new Order(new OrderBy(orderBy), OrderType.DESC);
    }
    
    @NonNull
    public static Order asc(@NonNull String orderBy) {
        return new Order(new OrderBy(orderBy), OrderType.ASC);
    }
    
    @NonNull
    public OrderBy orderBy() {
        return this.orderBy;
    }
    
    public void orderBy(@NonNull OrderBy orderBy) {
        this.orderBy = orderBy;
    }
    
    @NonNull
    public OrderType orderType() {
        return this.orderType;
    }
    
    public void orderType(@NonNull OrderType orderType) {
        this.orderType = orderType;
    }
    
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
    
    @NonNull
    @Override
    public String toString() {
        return "Order{" +
               "orderBy=" + orderBy +
               ", orderType=" + orderType +
               '}';
    }
}


