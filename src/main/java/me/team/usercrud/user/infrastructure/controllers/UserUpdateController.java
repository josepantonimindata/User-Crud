package me.team.usercrud.user.infrastructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.user.application.updateuser.UserUpdateService;
import me.team.usercrud.user.domain.User;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserUpdateController {
    private UserUpdateService userUpdateService;

    public UserUpdateController(UserUpdateService userUpdateService) {
        this.userUpdateService = userUpdateService;
    }

    @Operation(
        description = "Update a User",
        summary = "Update User",
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
    @PutMapping("/update/{id}")
    public void updateUser(@RequestBody User user) {
        User updatedUser = userUpdateService.updateUser(user);

        System.out.println("User updated: " + updatedUser);
    }

}
