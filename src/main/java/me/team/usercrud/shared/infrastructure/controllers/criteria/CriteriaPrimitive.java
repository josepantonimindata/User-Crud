package me.team.usercrud.shared.infrastructure.controllers.criteria;

import org.springframework.lang.Nullable;

import java.util.List;

public class CriteriaPrimitive {
    @Nullable
    private List<FilterPrimitive> filters;
    @Nullable
    private OrderPrimitive order;
    @Nullable
    private Integer offset;
    @Nullable
    private Integer limit;
    
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
    public Integer getLimit() {
        return limit;
    }
    
    public void setLimit(@Nullable Integer limit) {
        this.limit = limit;
    }
    
    @Nullable
    public Integer getOffset() {
        return offset;
    }
    
    public void setOffset(@Nullable Integer offset) {
        this.offset = offset;
    }
}
