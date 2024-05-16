package me.team.usercrud.shared.infrastructure.controllers.criteria;

import org.springframework.lang.Nullable;

import java.util.List;

public class CriteriaPrimitive {
    @Nullable
    private List<FilterPrimitive> filters;
    @Nullable
    private OrderPrimitive order;
    @Nullable
    private Integer page;
    @Nullable
    private Integer size;
    
    public CriteriaPrimitive(@Nullable List<FilterPrimitive> filters, @Nullable OrderPrimitive order) {
        this.order = order;
        this.filters = filters;
    }
    
    public CriteriaPrimitive() {}
    
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
    
    @Nullable
    public Integer getSize() {
        return size;
    }
    
    public void setSize(@Nullable Integer size) {
        this.size = size;
    }
    
    @Nullable
    public Integer getPage() {
        return page;
    }
    
    public void setPage(@Nullable Integer page) {
        this.page = page;
    }
}
