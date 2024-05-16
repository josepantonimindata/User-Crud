package me.team.usercrud.shared.domain.criteria;

public enum OrderType {
    ASC,
    DESC;
    
    public boolean isAsc() {
        return this == ASC;
    }
}
