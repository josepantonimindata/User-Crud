package me.team.usercrud.user.infrastructure.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.infrastructure.dto.UserDto;
import me.team.usercrud.user.domain.*;

public class UserDtoMapper implements Mapper<UserDto, User> {
    @Override
    public User from(UserDto userDto) {
        return new User(
            new UserId(userDto.id()),
            new UserName(userDto.name()),
            new UserSurname(userDto.surname()),
            new UserEmail(userDto.email()),
            new UserPassword(userDto.password()),
            new UserCreationTime(null),
            new UserLastEditTime(null)
        );
    }

    @Override
    public UserDto to(User user) {
        return new UserDto(
            user.id().value(),
            user.name().value(),
            user.surname().value(),
            user.email().value(),
            user.password().value()
        );
    }
}
