package me.team.usercrud.user.application.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID userId) {
        super("User with id " + userId + " does not exist");
    }
}
