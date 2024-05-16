package me.team.usercrud.shared.domain;

import org.springframework.lang.NonNull;

public interface Mapper<From, To> {
    @NonNull
    To map(@NonNull From from);
}
