package me.team.usercrud.application.user.exceptions;

import lombok.AllArgsConstructor;
import me.team.usercrud.domain.User;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID userId) {
        super("User with id " + userId + " does not exist");
    }
}
