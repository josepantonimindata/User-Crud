package me.team.usercrud.shared.domain.criteria;

import java.util.Objects;

public class Filter {
    private FilterField field;
    private FilterOperator operator;
    private FilterValue value;

    public Filter(FilterField field, FilterOperator operator, FilterValue value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public static Filter from(String field, FilterOperator operator, String value) {
        return new Filter(new FilterField(field), operator, new FilterValue(value));
    }

    public FilterField field() {return this.field;}

    public void field(FilterField field) {this.field = field;}

    public FilterOperator operator() {return this.operator;}

    public void operator(FilterOperator operator) {this.operator = operator;}

    public FilterValue value() {return this.value;}

    public void value(FilterValue value) {this.value = value;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filter filter = (Filter) o;
        return Objects.equals(field, filter.field) && operator == filter.operator && Objects.equals(value, filter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, operator, value);
    }

    @Override
    public String toString() {
        return "Filter{" +
            "field=" + field +
            ", operator=" + operator +
            ", value=" + value +
            '}';
    }
}

