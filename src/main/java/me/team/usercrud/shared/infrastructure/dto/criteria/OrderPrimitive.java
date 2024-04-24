package me.team.usercrud.shared.infrastructure.dto.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPrimitive {
    private String orderBy;
    private String orderType;

    public boolean hasOrder() {
        return orderType != null;
    }
}
