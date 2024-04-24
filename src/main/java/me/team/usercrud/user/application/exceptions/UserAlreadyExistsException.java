package me.team.usercrud.user.application.exceptions;

import me.team.usercrud.user.domain.User;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(User user) {
       super("User with id " + user.getId() + " already exists");
    }
}
