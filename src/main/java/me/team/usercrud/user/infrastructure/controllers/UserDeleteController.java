package me.team.usercrud.user.infrastructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import me.team.usercrud.user.application.deleteuser.UserDeleteService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserDeleteController {

    private UserDeleteService userDeleteService;

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
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable String id) {
        userDeleteService.deleteUserById(new UserId(id));
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User user) {
        userDeleteService.deleteUser(user);
    }
}
