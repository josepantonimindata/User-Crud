package me.team.usercrud.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Filter {
    private FilterField field;
    private FilterOperator operator;
    private FilterValue value;

    public static Filter from(String field, FilterOperator operator, String value) {
        return new Filter(new FilterField(field), operator, new FilterValue(value));
    }
}

