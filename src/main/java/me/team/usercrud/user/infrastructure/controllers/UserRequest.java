package me.team.usercrud.user.infrastructure.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserRequest(
    @JsonProperty String id,
    @JsonProperty String name,
    @JsonProperty String surname,
    @JsonProperty String email,
    @JsonProperty String password
) {
}
