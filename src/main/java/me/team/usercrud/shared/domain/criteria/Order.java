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

    public OrderBy getOrderBy()                   {return this.orderBy;}

    public void setOrderBy(OrderBy orderBy)       {this.orderBy = orderBy;}

    public OrderType getOrderType()               {return this.orderType;}

    public void setOrderType(OrderType orderType) {this.orderType = orderType;}

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Order other)) return false;
        if (!other.canEqual(this)) return false;
        final Object this$orderBy = this.getOrderBy();
        final Object other$orderBy = other.getOrderBy();
        if (!Objects.equals(this$orderBy, other$orderBy)) return false;
        final Object this$orderType = this.getOrderType();
        final Object other$orderType = other.getOrderType();
        return Objects.equals(this$orderType, other$orderType);
    }

    protected boolean canEqual(final Object other) {return other instanceof Order;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $orderBy = this.getOrderBy();
        result = result * PRIME + ($orderBy == null ? 43 : $orderBy.hashCode());
        final Object $orderType = this.getOrderType();
        result = result * PRIME + ($orderType == null ? 43 : $orderType.hashCode());
        return result;
    }

    public String toString() {return "Order(orderBy=" + this.getOrderBy() + ", orderType=" + this.getOrderType() + ")";}
}


