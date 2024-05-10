package me.team.usercrud.shared.infrastructure.controllers.criteria;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class FilterPrimitive {
    @NonNull
    private String field;
    @NonNull
    private String operator;
    @NonNull
    private String value;
    
    public FilterPrimitive(@NonNull String field, @NonNull String operator, @NonNull String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }
    
    @NonNull
    public String getField() {return this.field;}
    
    public void setField(@NonNull String field) {this.field = field;}
    
    @NonNull
    public String getOperator() {return this.operator;}
    
    public void setOperator(@NonNull String operator) {this.operator = operator;}
    
    @NonNull
    public String getValue() {return this.value;}
    
    public void setValue(@NonNull String value) {this.value = value;}
    
    public String toString() {return "FilterPrimitive(field=" + this.getField() + ", operator=" + this.getOperator() + ", value=" + this.getValue() + ")";}
    
    /// Generated Methods
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilterPrimitive that = (FilterPrimitive) o;
        return Objects.equals(getField(), that.getField()) && Objects.equals(getOperator(),
            that.getOperator()) && Objects.equals(getValue(), that.getValue());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getField(), getOperator(), getValue());
    }
}
