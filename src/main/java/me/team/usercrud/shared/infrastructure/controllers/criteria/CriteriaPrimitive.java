package me.team.usercrud.shared.infrastructure.controllers.criteria;

import java.util.List;

public class CriteriaPrimitive {
    private List<FilterPrimitive> filters;
    private OrderPrimitive order;
    
    public CriteriaPrimitive(List<FilterPrimitive> filters, OrderPrimitive order) {
        this.order = order;
        this.filters = filters;
    }
    
    public CriteriaPrimitive() {}
    
    public boolean hasOrder() {
        return order != null && order.hasOrder();
    }
    
    public OrderPrimitive getOrder() {
        return this.order;
    }
    
    public void setOrder(OrderPrimitive order) {
        this.order = order;
    }
    
    public List<FilterPrimitive> getFilters() {
        return this.filters;
    }
    
    public void setFilters(List<FilterPrimitive> filters) {
        this.filters = filters;
    }
    
}
