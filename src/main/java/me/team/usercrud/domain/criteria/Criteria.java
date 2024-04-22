package me.team.usercrud.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Criteria {
    private Filters filters;
    private Order order;

    public boolean hasOrder() {
        return order != null && order.hasOrder();
    }

    public boolean hasFilters() {
        return filters != null && !filters.isEmpty();
    }
}

