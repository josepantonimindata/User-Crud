package me.team.usercrud.shared.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface Mapper<From, To> {
    
    @Nullable
    To from(@NonNull From from);
    
    @Nullable
    From to(@NonNull To to);
}
