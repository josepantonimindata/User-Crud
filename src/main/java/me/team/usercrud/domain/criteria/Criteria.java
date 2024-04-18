package me.team.usercrud.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
    private List<Filter> filters;
    private Order order;
}

