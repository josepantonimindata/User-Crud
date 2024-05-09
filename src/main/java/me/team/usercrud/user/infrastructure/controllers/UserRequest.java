package me.team.usercrud.user.infrastructure.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record UserRequest(
    @JsonProperty UUID id,
    @JsonProperty String name,
    @JsonProperty String surname,
    @JsonProperty String email,
    @JsonProperty String password
) {
}
