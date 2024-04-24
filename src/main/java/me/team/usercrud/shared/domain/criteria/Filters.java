package me.team.usercrud.shared.domain.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filters {
    List<Filter> filters;

    public Filters(List<Filter> filters) {
        this.filters = filters;
    }

    public static Filters empty() {
        return new Filters(new ArrayList<>());
    }

    public boolean isEmpty() {
        return filters.isEmpty();
    }

    public List<Filter> filters() {return this.filters;}

    public void filters(List<Filter> filters) {this.filters = filters;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filters filters1 = (Filters) o;
        return Objects.equals(filters, filters1.filters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filters);
    }

    @Override
    public String toString() {
        return "Filters{" +
            "filters=" + filters +
            '}';
    }
}
