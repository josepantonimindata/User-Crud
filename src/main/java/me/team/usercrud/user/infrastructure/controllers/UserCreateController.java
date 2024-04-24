package me.team.usercrud.user.infrastructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.user.application.createuser.UserCreateService;
import me.team.usercrud.user.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCreateController {

    private final UserCreateService userCreateService;

    public UserCreateController(UserCreateService userCreateService) {this.userCreateService = userCreateService;}

    @Operation(
        description = "Create a new User, the user ID field must be unique and with UUID format",
        summary = "Create new User with UUID unique",
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "201"
            ),
            @ApiResponse(
                description = "Conflict, User UUID already exists",
                responseCode = "409"
            )
        }
    )
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        User newUser = userCreateService.createUser(user);

        System.out.println("User created: " + newUser);
    }
}
