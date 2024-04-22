package me.team.usercrud.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Filters {
    List<Filter> filters;

    public static Filters empty() {
        return new Filters(new ArrayList<>());
    }

    public boolean isEmpty() {
        return filters.isEmpty();
    }
}
