package me.team.usercrud.user.infrastructure.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.services.DateTimeUtils;
import me.team.usercrud.user.domain.*;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDtoToUser implements Mapper<UserRequest, User> {
    @Override
    public User from(@NonNull UserRequest userDto) {
        return new User(
            new UserId(userDto.id().toString()),
            new UserName(userDto.name()),
            new UserSurname(userDto.surname()),
            new UserEmail(userDto.email()),
            new UserPassword(userDto.password()),
            new UserCreationTime(DateTimeUtils.getNowTimeInString()),
            new UserLastEditTime(DateTimeUtils.getNowTimeInString())
        );
    }
    
    @Override
    public UserRequest to(@NonNull User user) {
        return new UserRequest(
            UUID.fromString(user.id().value()),
            user.name().value(),
            user.surname().value(),
            user.email().value(),
            user.password().value()
        );
    }
}
