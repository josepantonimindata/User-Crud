package me.team.usercrud.user.application.exceptions;

import me.team.usercrud.user.domain.UserId;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UserId userId) {
        super("User with id " + userId.value() + " does not exist");
    }
}
