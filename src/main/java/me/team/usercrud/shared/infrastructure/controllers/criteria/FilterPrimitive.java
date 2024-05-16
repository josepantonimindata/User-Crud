package me.team.usercrud.shared.infrastructure.controllers.criteria;

import org.springframework.lang.Nullable;

public class FilterPrimitive {
    @Nullable
    private String field;
    @Nullable
    private String operator;
    @Nullable
    private String value;
    
    public FilterPrimitive(@Nullable String field, @Nullable String operator, @Nullable String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }
    
    public FilterPrimitive() {}
    
    @Nullable
    public String getField() {
        return this.field;
    }
    
    public void setField(@Nullable String field) {
        this.field = field;
    }
    
    @Nullable
    public String getOperator() {
        return this.operator;
    }
    
    public void setOperator(@Nullable String operator) {
        this.operator = operator;
    }
    
    @Nullable
    public String getValue() {
        return this.value;
    }
    
    public void setValue(@Nullable String value) {
        this.value = value;
    }
}
