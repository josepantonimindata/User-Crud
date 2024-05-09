package me.team.usercrud.user.infrastructure.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.infrastructure.dto.UserDto;
import me.team.usercrud.user.domain.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDtoToUser implements Mapper<UserDto, User> {
    @Override
    public User from(@NonNull UserDto userDto) {
        return new User(
            new UserId(userDto.id().toString()),
            new UserName(userDto.name()),
            new UserSurname(userDto.surname()),
            new UserEmail(userDto.email()),
            new UserPassword(userDto.password()),
            new UserCreationTime(null),
            new UserLastEditTime(null)
        );
    }
    
    @Override
    public UserDto to(@NonNull User user) {
        return new UserDto(
            UUID.fromString(user.id().value()),
            user.name().value(),
            user.surname().value(),
            user.email().value(),
            user.password().value()
        );
    }
}
