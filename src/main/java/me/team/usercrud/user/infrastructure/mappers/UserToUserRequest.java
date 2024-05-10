package me.team.usercrud.user.infrastructure.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserToUserRequest implements Mapper<User, UserRequest> {
    
    @NonNull
    @Override
    public UserRequest map(@NonNull User user) {
        return new UserRequest(
            UUID.fromString(user.id().value()),
            user.name().value(),
            user.surname().value(),
            user.email().value(),
            user.password().value()
        );
    }
}
