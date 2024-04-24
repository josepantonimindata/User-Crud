package me.team.usercrud.shared.domain;

public interface Mapper<From, To> {
    To from(From from);

    From to(To to);
}
