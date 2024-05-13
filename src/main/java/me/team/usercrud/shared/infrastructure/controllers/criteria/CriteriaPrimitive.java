package me.team.usercrud.shared.infrastructure.controllers.criteria;

import org.springframework.lang.Nullable;

import java.util.List;

public class CriteriaPrimitive {
    @Nullable
    private List<FilterPrimitive> filters;
    @Nullable
    private OrderPrimitive order;
    
    public CriteriaPrimitive(@Nullable List<FilterPrimitive> filters, @Nullable OrderPrimitive order) {
        this.order = order;
        this.filters = filters;
    }
    
    public CriteriaPrimitive() { }
    
    public boolean hasOrder() {
        return order != null && order.hasOrder();
    }
    
    @Nullable
    public OrderPrimitive getOrder() {
        return this.order;
    }
    
    public void setOrder(@Nullable OrderPrimitive order) {
        this.order = order;
    }
    
    @Nullable
    public List<FilterPrimitive> getFilters() {
        return this.filters;
    }
    
    public void setFilters(@Nullable List<FilterPrimitive> filters) {
        this.filters = filters;
    }
}
