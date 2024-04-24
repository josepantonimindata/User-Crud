package me.team.usercrud.shared.infrastructure.dto.criteria;

import java.util.Objects;

public class FilterPrimitive {
    private String field;
    private String operator;
    private String value;

    public FilterPrimitive(String field, String operator, String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public FilterPrimitive()                 {}

    public String getField()                 {return this.field;}

    public void setField(String field)       {this.field = field;}

    public String getOperator()              {return this.operator;}

    public void setOperator(String operator) {this.operator = operator;}

    public String getValue()                 {return this.value;}

    public void setValue(String value)       {this.value = value;}

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FilterPrimitive other)) return false;
        if (!other.canEqual(this)) return false;
        final Object this$field = this.getField();
        final Object other$field = other.getField();
        if (!Objects.equals(this$field, other$field)) return false;
        final Object this$operator = this.getOperator();
        final Object other$operator = other.getOperator();
        if (!Objects.equals(this$operator, other$operator)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        return Objects.equals(this$value, other$value);
    }

    protected boolean canEqual(final Object other) {return other instanceof FilterPrimitive;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $field = this.getField();
        result = result * PRIME + ($field == null ? 43 : $field.hashCode());
        final Object $operator = this.getOperator();
        result = result * PRIME + ($operator == null ? 43 : $operator.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    public String toString() {return "FilterPrimitive(field=" + this.getField() + ", operator=" + this.getOperator() + ", value=" + this.getValue() + ")";}
}
