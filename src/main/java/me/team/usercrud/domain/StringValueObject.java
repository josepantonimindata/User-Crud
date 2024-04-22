package me.team.usercrud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public abstract class StringValueObject {
    private String value;
}
