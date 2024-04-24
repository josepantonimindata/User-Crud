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

    public List<Filter> getFilters()             {return this.filters;}

    public void setFilters(List<Filter> filters) {this.filters = filters;}

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Filters other)) return false;
        if (!other.canEqual(this)) return false;
        final Object this$filters = this.getFilters();
        final Object other$filters = other.getFilters();
        return Objects.equals(this$filters, other$filters);
    }

    protected boolean canEqual(final Object other) {return other instanceof Filters;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $filters = this.getFilters();
        result = result * PRIME + ($filters == null ? 43 : $filters.hashCode());
        return result;
    }

    public String toString() {return "Filters(filters=" + this.getFilters() + ")";}
}
