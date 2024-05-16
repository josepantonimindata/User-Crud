package me.team.usercrud.shared.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
    info = @Info(
        title = "User Proxy API Database",
        version = "1.0.0",
        description = "Proxy API - Service of the database CRUD & Criteria - User"
    ),
    servers = {
        @Server(
            description = "Dev Server",
            url = "http://localhost/"
        ),
    },
    tags = {
        @Tag( name = "User", description = "User Endpoints")
    }

)
public class OpenApi {

}
