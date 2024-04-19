package me.team.usercrud.application.user.exceptions;

import me.team.usercrud.domain.User;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(User user) {
       super("User with id " + user.getId() + " already exists");
    }
}
