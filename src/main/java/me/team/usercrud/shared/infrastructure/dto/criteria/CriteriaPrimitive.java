package me.team.usercrud.shared.infrastructure.dto.criteria;

import java.util.List;
import java.util.Objects;

public class CriteriaPrimitive {
    private List<FilterPrimitive> filters;
    private OrderPrimitive order;

    public CriteriaPrimitive(List<FilterPrimitive> filters, OrderPrimitive order) {
        this.order = order;
        this.filters = filters;
    }

    public CriteriaPrimitive() {}

    public boolean hasOrder() {
        return order != null && order.hasOrder();
    }

    public OrderPrimitive getOrder()                      {return this.order;}

    public void setOrder(OrderPrimitive order)            {this.order = order;}

    public List<FilterPrimitive> getFilters()             {return this.filters;}

    public void setFilters(List<FilterPrimitive> filters) {this.filters = filters;}

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CriteriaPrimitive other)) return false;
        if (!other.canEqual(this)) return false;
        final Object this$order = this.getOrder();
        final Object other$order = other.getOrder();
        if (!Objects.equals(this$order, other$order)) return false;
        final Object this$filters = this.getFilters();
        final Object other$filters = other.getFilters();
        return Objects.equals(this$filters, other$filters);
    }

    protected boolean canEqual(final Object other) {return other instanceof CriteriaPrimitive;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $order = this.getOrder();
        result = result * PRIME + ($order == null ? 43 : $order.hashCode());
        final Object $filters = this.getFilters();
        result = result * PRIME + ($filters == null ? 43 : $filters.hashCode());
        return result;
    }

    public String toString() {return "CriteriaPrimitive(order=" + this.getOrder() + ", filters=" + this.getFilters() + ")";}
}

