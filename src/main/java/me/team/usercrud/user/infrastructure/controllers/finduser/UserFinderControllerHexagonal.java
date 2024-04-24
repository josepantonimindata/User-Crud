package me.team.usercrud.user.infrastructure.controllers.finduser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import me.team.usercrud.user.application.finduser.UserFinderService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserFinderControllerHexagonal {

    private UserFinderService userFinderService;

    @Operation(
        description = "Find a User by ID",
        summary = "Find User by ID",
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
    @GetMapping("/hexagonal/users/{id}")
    public User getUser(@PathVariable String id) {
        return userFinderService.findUser(new UserId(id));
    }

    @GetMapping("/hexagonal/users")
    public List<User> findAll() {
        return userFinderService.findAll();
    }


}
