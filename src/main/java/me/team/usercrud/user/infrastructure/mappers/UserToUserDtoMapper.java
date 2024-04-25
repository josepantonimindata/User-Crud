package me.team.usercrud.user.infrastructure.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.infrastructure.dto.UserDto;
import me.team.usercrud.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoMapper implements Mapper<User, UserDto> {

    private final Mapper<UserDto, User> mapper;

    public UserToUserDtoMapper(Mapper<UserDto, User> mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDto from(User fromType) {
        return mapper.to(fromType);
    }

    @Override
    public User to(UserDto toType) {
        return mapper.from(toType);
    }
}