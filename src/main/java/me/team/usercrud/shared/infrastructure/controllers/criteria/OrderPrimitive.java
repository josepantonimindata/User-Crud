package me.team.usercrud.shared.infrastructure.controllers.criteria;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class OrderPrimitive {
    @NonNull
    private String orderBy;
    @NonNull
    private String orderType;
    
    public OrderPrimitive(@NonNull String orderBy, @NonNull String orderType) {
        this.orderBy = orderBy;
        this.orderType = orderType;
    }
    
    @NonNull
    public String getOrderBy() {return this.orderBy;}
    
    public void setOrderBy(@NonNull String orderBy) {this.orderBy = orderBy;}
    
    @NonNull
    public String getOrderType() {return this.orderType;}
    
    public void setOrderType(@NonNull String orderType) {this.orderType = orderType;}
    
    /// Generated Methods
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPrimitive that = (OrderPrimitive) o;
        return Objects.equals(getOrderBy(), that.getOrderBy()) && Objects.equals(getOrderType(),
            that.getOrderType());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getOrderBy(), getOrderType());
    }
}
