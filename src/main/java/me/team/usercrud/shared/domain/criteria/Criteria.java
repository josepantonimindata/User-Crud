package me.team.usercrud.shared.domain.criteria;

import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Criteria {
    @NonNull
    private Optional<List<Filter>> filters;
    @NonNull
    private Optional<Order> order;
    
    public Criteria(
        @NonNull Optional<List<Filter>> filters, @NonNull Optional<Order> order
    ) {
        this.filters = filters;
        this.order = order;
    }
    
    public Criteria(
        @NonNull List<Filter> filters, @NonNull Order order
    ) {
        this.filters = Optional.of(filters);
        this.order = Optional.of(order);
    }
    
    @NonNull
    public static Criteria none() {
        return new Criteria(Optional.empty(), Optional.empty());
    }
    
    @NonNull
    public static Criteria withOrder(@NonNull Order order) {
        return new Criteria(Optional.empty(), Optional.of(order));
    }
    
    @NonNull
    public static Criteria withFilters(@NonNull List<Filter> filters) {
        return new Criteria(Optional.of(filters), Optional.empty());
    }
    
    @NonNull
    public Optional<List<Filter>> filters() {
        return this.filters;
    }
    
    public void filters(@NonNull List<Filter> filters) {
        this.filters = Optional.of(filters);
    }
    
    @NonNull
    public Optional<Order> order() {
        return this.order;
    }
    
    public void order(@NonNull Order order) {
        this.order = Optional.of(order);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criteria criteria = (Criteria) o;
        return Objects.equals(filters, criteria.filters) && Objects.equals(order, criteria.order);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(filters, order);
    }
    
    @Override
    public String toString() {
        return "Criteria{" +
               "filters=" + filters +
               ", order=" + order +
               '}';
    }
}

