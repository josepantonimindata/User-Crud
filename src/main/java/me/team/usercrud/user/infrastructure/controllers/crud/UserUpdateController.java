package me.team.usercrud.user.infrastructure.controllers.crud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.user.application.crud.UserUpdateService;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserUpdateController {
    
    private final UserUpdateService userUpdateService;
    
    public UserUpdateController(UserUpdateService userUpdateService) {
        this.userUpdateService = userUpdateService;
    }
    
    @Operation(
        summary = "Update a User",
        description = "Update User, based on the body.",
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                useReturnTypeSchema = true
            ),
            @ApiResponse(
                description = "Not Found, User not found",
                responseCode = "404",
                content = @Content(
                    mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetail.class)
                )
            )
        },
        tags = {"User"}
    )
    @PutMapping("/users")
    public void updateUser(@RequestBody UserRequest user) {
        userUpdateService.updateUser(
            user.id().toString(),
            user.name(),
            user.surname(),
            user.email(),
            user.password()
        );
    }
}
