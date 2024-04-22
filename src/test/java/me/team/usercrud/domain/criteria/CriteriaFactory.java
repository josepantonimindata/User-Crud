package me.team.usercrud.domain.criteria;

import java.util.List;

public class CriteriaFactory {

    public static Criteria empty() {
        return new Criteria(
            Filters.empty(),
            Order.none()
        );
    }

    public static Criteria asc(String field) {
        return new Criteria(
            Filters.empty(),
            Order.asc(field)
        );
    }

    public static Criteria contains(String field, String value) {
        return new Criteria(
            Filters.from(List.of(new Filter(new FilterField(field), FilterOperator.CONTAINS, new FilterValue(value)))),
            Order.none()
        );
    }
}