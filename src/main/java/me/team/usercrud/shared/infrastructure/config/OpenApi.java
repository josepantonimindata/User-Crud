package me.team.usercrud.shared.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "User Proxy API Database",
        version = "1.0.0",
        description = "Proxy API - Service of the database CRUD & Criteria - User"
    )
)
public class OpenApi {}
