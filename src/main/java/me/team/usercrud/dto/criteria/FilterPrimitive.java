package me.team.usercrud.dto.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterPrimitive {
    private String field;
    private String operator;
    private String value;
}
