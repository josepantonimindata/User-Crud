package me.team.usercrud.dto.criteria;

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
}

