package me.team.usercrud.user.infrastructure.controllers.crud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.application.crud.UserFinderService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserReaderController {
    
    private final UserFinderService userFinderService;
    private final Mapper<UserRequest, User> mapper;
    
    public UserReaderController(UserFinderService userFinderService, Mapper<UserRequest, User> mapper) {
        this.userFinderService = userFinderService;
        this.mapper = mapper;
    }
    
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
    @GetMapping("/users/{id}")
    public UserRequest getUser(@PathVariable UUID id) {
        var user = userFinderService.findUser(id.toString());
        
        return mapper.to(user);
    }
    
    @GetMapping("/users")
    public List<UserRequest> findAll() {
        return userFinderService.findAll().stream().map(mapper::to).toList();
    }
}
