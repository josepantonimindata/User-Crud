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

    public Filters filters()             {return this.filters;}

    public void filters(Filters filters) {this.filters = filters;}

    public Order order()                 {return this.order;}

    public void order(Order order)       {this.order = order;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criteria criteria = (Criteria) o;
        return Objects.equals(filters, criteria.filters) && Objects.equals(order, criteria.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filters, order);
    }

    @Override
    public String toString() {
        return "Criteria{" +
            "filters=" + filters +
            ", order=" + order +
            '}';
    }
}

