package me.team.usercrud.user.infrastructure.controllers.crud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.application.crud.UserFinderService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class UserReaderController {
    
    private final UserFinderService userFinderService;
    private final Mapper<User, UserRequest> mapper;
    
    public UserReaderController(UserFinderService userFinderService, Mapper<User, UserRequest> mapper) {
        this.userFinderService = userFinderService;
        this.mapper = mapper;
    }
    
    @Operation(
        summary = "Find a User by ID",
        description = "Find User by ID",
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
    @GetMapping("/users/{id}")
    public UserRequest getUser(@PathVariable UUID id) {
        var user = userFinderService.findUser(id.toString());
        
        return mapper.map(user);
    }
    
    @Operation(
        summary = "Get all Users",
        description = "Get all Users on the database.",
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                useReturnTypeSchema = true
            ),
        },
        tags = {"User"}
    )
    @GetMapping("/users")
    public List<UserRequest> findAll() {
        return userFinderService.findAll().stream().map(mapper::map).toList();
    }
}
