package me.team.usercrud.shared.infrastructure.controllers.criteria;

import org.springframework.lang.Nullable;

public class OrderPrimitive {
    @Nullable
    private String orderBy;
    @Nullable
    private String orderType;
    
    public OrderPrimitive(@Nullable String orderBy, @Nullable String orderType) {
        this.orderBy = orderBy;
        this.orderType = orderType;
    }
    
    public OrderPrimitive() {}
    
    public boolean hasOrder() {
        return orderType != null && orderBy != null;
    }
    
    @Nullable
    public String getOrderBy() {
        return this.orderBy;
    }
    
    public void setOrderBy(@Nullable String orderBy) {
        this.orderBy = orderBy;
    }
    
    @Nullable
    public String getOrderType() {
        return this.orderType;
    }
    
    public void setOrderType(@Nullable String orderType) {
        this.orderType = orderType;
    }
    
}
