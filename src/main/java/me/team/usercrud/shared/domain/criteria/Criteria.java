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
    @NonNull
    private Optional<Integer> offset;
    @NonNull
    private Optional<Integer> limit;
    
    public Criteria(
        @NonNull Optional<List<Filter>> filters, @NonNull Optional<Order> order,
        @NonNull Optional<Integer> offset, @NonNull Optional<Integer> limit
    ) {
        this.filters = filters;
        this.order = order;
        this.offset = offset;
        this.limit = limit;
    }
    
    public Criteria(
        @NonNull List<Filter> filters, @NonNull Order order, @NonNull int offset,
        @NonNull int limit
    ) {
        this.filters = Optional.of(filters);
        this.order = Optional.of(order);
        this.offset = Optional.of(offset);
        this.limit = Optional.of(limit);
    }
    
    @NonNull
    public static Criteria none() {
        return new Criteria(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }
    
    @NonNull
    public static Criteria withOrder(@NonNull Order order) {
        return new Criteria(Optional.empty(), Optional.of(order), Optional.empty(), Optional.empty());
    }
    
    @NonNull
    public static Criteria withFilters(@NonNull List<Filter> filters) {
        return new Criteria(Optional.of(filters), Optional.empty(), Optional.empty(), Optional.empty());
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
    
    @NonNull
    public Optional<Integer> limit() {
        return limit;
    }
    
    public void limit(@NonNull Integer limit) {
        this.limit = Optional.of(limit);
    }
    
    @NonNull
    public Optional<Integer> offset() {
        return offset;
    }
    
    public void offset(@NonNull Integer offset) {
        this.offset = Optional.of(offset);
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

