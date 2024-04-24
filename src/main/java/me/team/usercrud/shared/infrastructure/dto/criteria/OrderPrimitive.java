package me.team.usercrud.shared.infrastructure.dto.criteria;

import java.util.Objects;

public class OrderPrimitive {
    private String orderBy;
    private String orderType;

    public OrderPrimitive(String orderBy, String orderType) {
        this.orderBy = orderBy;
        this.orderType = orderType;
    }

    public OrderPrimitive() {}

    public boolean hasOrder() {
        return orderType != null;
    }

    public String getOrderBy()                 {return this.orderBy;}

    public void setOrderBy(String orderBy)     {this.orderBy = orderBy;}

    public String getOrderType()               {return this.orderType;}

    public void setOrderType(String orderType) {this.orderType = orderType;}

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderPrimitive other)) return false;
        if (!other.canEqual(this)) return false;
        final Object this$orderBy = this.getOrderBy();
        final Object other$orderBy = other.getOrderBy();
        if (!Objects.equals(this$orderBy, other$orderBy)) return false;
        final Object this$orderType = this.getOrderType();
        final Object other$orderType = other.getOrderType();
        return Objects.equals(this$orderType, other$orderType);
    }

    protected boolean canEqual(final Object other) {return other instanceof OrderPrimitive;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $orderBy = this.getOrderBy();
        result = result * PRIME + ($orderBy == null ? 43 : $orderBy.hashCode());
        final Object $orderType = this.getOrderType();
        result = result * PRIME + ($orderType == null ? 43 : $orderType.hashCode());
        return result;
    }

    public String toString() {return "OrderPrimitive(orderBy=" + this.getOrderBy() + ", orderType=" + this.getOrderType() + ")";}
}
