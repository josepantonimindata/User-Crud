package me.team.usercrud.application.dto.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaPrimitive {
    private OrderPrimitive order;
    private List<FilterPrimitive> filters;

    public boolean hasOrder() {
        return order != null && order.hasOrder();
    }
}

