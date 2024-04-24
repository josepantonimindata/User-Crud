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

    public FilterField getField()                    {return this.field;}

    public void setField(FilterField field)          {this.field = field;}

    public FilterOperator getOperator()              {return this.operator;}

    public void setOperator(FilterOperator operator) {this.operator = operator;}

    public FilterValue getValue()                    {return this.value;}

    public void setValue(FilterValue value)          {this.value = value;}

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Filter other)) return false;
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

    protected boolean canEqual(final Object other) {return other instanceof Filter;}

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

    public String toString() {return "Filter(field=" + this.getField() + ", operator=" + this.getOperator() + ", value=" + this.getValue() + ")";}
}

