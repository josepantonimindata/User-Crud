package me.team.usercrud.shared.infrastructure.controllers.criteria;

import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CriteriaPrimitive {
    
    @NonNull
    private Optional<List<FilterPrimitive>> filters;
    @NonNull
    private Optional<OrderPrimitive> order;
    
    public CriteriaPrimitive(
        @NonNull Optional<List<FilterPrimitive>> filters,
        @NonNull Optional<OrderPrimitive> order
    ) {
        this.order = order;
        this.filters = filters;
    }
    
    public CriteriaPrimitive(@NonNull List<FilterPrimitive> filters, @NonNull OrderPrimitive order) {
        this.filters = Optional.of(filters);
        this.order = Optional.of(order);
    }
    
    public static CriteriaPrimitive none() {
        return new CriteriaPrimitive(Optional.empty(), Optional.empty());
    }
    
    @NonNull
    public static CriteriaPrimitive withOrder(@NonNull OrderPrimitive order) {
        return new CriteriaPrimitive(Optional.empty(), Optional.of(order));
    }
    
    @NonNull
    public static CriteriaPrimitive withFilters(@NonNull List<FilterPrimitive> filters) {
        return new CriteriaPrimitive(Optional.of(filters), Optional.empty());
    }
    
    @NonNull
    public Optional<OrderPrimitive> order() {
        return this.order;
    }
    
    public void order(@NonNull Optional<OrderPrimitive> order) {
        this.order = order;
    }
    
    @NonNull
    public Optional<List<FilterPrimitive>> filters() {
        return this.filters;
    }
    
    public void filters(@NonNull Optional<List<FilterPrimitive>> filters) {
        this.filters = filters;
    }
    
    /// Generated Methods
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteriaPrimitive that = (CriteriaPrimitive) o;
        return Objects.equals(filters, that.filters) && Objects.equals(order, that.order);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(filters, order);
    }
}

