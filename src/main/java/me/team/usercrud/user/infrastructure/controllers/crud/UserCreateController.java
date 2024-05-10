package me.team.usercrud.user.infrastructure.controllers.crud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.user.application.crud.UserCreateService;
import me.team.usercrud.user.domain.*;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserCreateController {
    
    private final UserCreateService userCreateService;
    
    public UserCreateController(UserCreateService userCreateService) {
        this.userCreateService = userCreateService;
    }
    
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
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest user) {
        userCreateService.createUser(
            new UserId(user.id().toString()),
            new UserName(user.name()),
            new UserSurname(user.surname()),
            new UserEmail(user.email()),
            new UserPassword(user.password())
        );
    }
}
