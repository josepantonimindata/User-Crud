package me.team.usercrud.domain.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class Filters {
    List<Filter> filters;

    public static Filters empty() {
        return new Filters(new ArrayList<>());
    }

    public static Filters from(Collection<Filter> collection) {
        return new Filters(new ArrayList<>(collection));
    }

    public boolean isEmpty() {
        return filters.isEmpty();
    }
}
