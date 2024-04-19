package me.team.usercrud.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filter {
    private FilterField field;
    private FilterOperator operator;
    private FilterValue value;
}

