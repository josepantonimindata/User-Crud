package me.team.usercrud.shared.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
    private Filters filters;
    private Order order;

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
}

