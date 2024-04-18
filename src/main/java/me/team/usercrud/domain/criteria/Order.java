package me.team.usercrud.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private OrderBy orderBy;
    private OrderType orderType;
}
