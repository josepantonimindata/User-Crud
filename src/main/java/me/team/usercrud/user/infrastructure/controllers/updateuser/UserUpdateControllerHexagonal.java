package me.team.usercrud.user.infrastructure.controllers.updateuser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.user.application.updateuser.UserUpdateService;
import me.team.usercrud.user.domain.*;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserUpdateControllerHexagonal {

    private final UserUpdateService userUpdateService;

    public UserUpdateControllerHexagonal(UserUpdateService userUpdateService) {
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
    @PutMapping("/hexagonal/update/{id}")
    public void updateUser(@RequestBody UserRequest user) {
        User updatedUser = userUpdateService.updateUser(
                new UserId(user.id()),
                new UserName(user.name()),
                new UserSurname(user.surname()),
                new UserEmail(user.email()),
                new UserPassword(user.password())
        );

        System.out.println("User updated: " + updatedUser);
    }

}
