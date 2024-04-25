package me.team.usercrud.user.infrastructure.controllers.createuser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.user.application.createuser.UserCreateService;
import me.team.usercrud.user.domain.*;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCreateControllerHexagonal {

    private final UserCreateService userCreateService;

    public UserCreateControllerHexagonal(UserCreateService userCreateService) {this.userCreateService = userCreateService;}

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
    @PostMapping("/hexagonal/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest user) {
        User newUser = userCreateService.createUser(
                new UserId(user.id()),
                new UserName(user.name()),
                new UserSurname(user.surname()),
                new UserEmail(user.email()),
                new UserPassword(user.password())
        );

        System.out.println("User created: " + newUser);
    }
}
