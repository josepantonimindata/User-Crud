package me.team.usercrud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public abstract class StringValueObject implements Serializable {
    private String value;
}
