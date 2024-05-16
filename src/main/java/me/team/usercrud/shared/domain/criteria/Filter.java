package me.team.usercrud.shared.domain.criteria;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class Filter {
    @NonNull
    private FilterField field;
    @NonNull
    private FilterOperator operator;
    @NonNull
    private FilterValue value;
    
    public Filter(@NonNull FilterField field, @NonNull FilterOperator operator, @NonNull FilterValue value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }
    
    @NonNull
    public static Filter from(@NonNull String field, @NonNull FilterOperator operator, @NonNull String value) {
        return new Filter(new FilterField(field), operator, new FilterValue(value));
    }
    
    @NonNull
    public FilterField field() {return this.field;}
    
    public void field(@NonNull FilterField field) {this.field = field;}
    
    @NonNull
    public FilterOperator operator() {return this.operator;}
    
    public void operator(@NonNull FilterOperator operator) {this.operator = operator;}
    
    @NonNull
    public FilterValue value() {return this.value;}
    
    public void value(@NonNull FilterValue value) {this.value = value;}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filter filter = (Filter) o;
        return Objects.equals(field, filter.field) && operator == filter.operator && Objects.equals(value,
            filter.value);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(field, operator, value);
    }
    
    @NonNull
    @Override
    public String toString() {
        return "Filter{" +
               "field=" + field +
               ", operator=" + operator +
               ", value=" + value +
               '}';
    }
}

