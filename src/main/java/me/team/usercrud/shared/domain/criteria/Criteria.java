package me.team.usercrud.shared.domain.criteria;

import java.util.Objects;

public class Criteria {
    private Filters filters;
    private Order order;

    public Criteria(Filters filters, Order order) {
        this.filters = filters;
        this.order = order;
    }

    public static Criteria none() {
        return new Criteria(Filters.empty(), Order.none());
    }

    public static Criteria withOrder(Order order) {
        return new Criteria(Filters.empty(), order);
    }

    public static Criteria withFilters(Filters filters) {
        return new Criteria(filters, Order.none());
    }

    public boolean hasOrder() {
        return order != null && order.hasOrder();
    }

    public boolean hasFilters() {
        return filters != null && !filters.isEmpty();
    }

    public Filters getFilters()             {return this.filters;}

    public void setFilters(Filters filters) {this.filters = filters;}

    public Order getOrder()                 {return this.order;}

    public void setOrder(Order order)       {this.order = order;}

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Criteria other)) return false;
        if (!other.canEqual(this)) return false;
        final Object this$filters = this.getFilters();
        final Object other$filters = other.getFilters();
        if (!Objects.equals(this$filters, other$filters)) return false;
        final Object this$order = this.getOrder();
        final Object other$order = other.getOrder();
        return Objects.equals(this$order, other$order);
    }

    protected boolean canEqual(final Object other) {return other instanceof Criteria;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $filters = this.getFilters();
        result = result * PRIME + ($filters == null ? 43 : $filters.hashCode());
        final Object $order = this.getOrder();
        result = result * PRIME + ($order == null ? 43 : $order.hashCode());
        return result;
    }

    public String toString() {return "Criteria(filters=" + this.getFilters() + ", order=" + this.getOrder() + ")";}
}

