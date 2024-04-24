package me.team.usercrud.shared.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private OrderBy orderBy;
    private OrderType orderType;

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
}


