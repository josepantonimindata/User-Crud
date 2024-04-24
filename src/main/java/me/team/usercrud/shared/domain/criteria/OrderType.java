package me.team.usercrud.shared.domain.criteria;

public enum OrderType {
    ASC,
    DESC,
    NONE;

    public boolean isNone() {
        return this == NONE;
    }

    public boolean isAsc() {
        return this == ASC;
    }
}
