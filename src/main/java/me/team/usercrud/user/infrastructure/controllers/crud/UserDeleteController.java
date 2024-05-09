package me.team.usercrud.user.infrastructure.controllers.crud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.user.application.crud.UserDeleteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserDeleteController {
    
    private final UserDeleteService userDeleteService;
    
    public UserDeleteController(UserDeleteService userDeleteService) {
        this.userDeleteService = userDeleteService;
    }
    
    @Operation(
        description = "Delete a User by ID",
        summary = "Delete User by ID",
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Not Found, User not found",
                responseCode = "404"
            )
        }
    )
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userDeleteService.deleteUserById(id.toString());
    }
}
