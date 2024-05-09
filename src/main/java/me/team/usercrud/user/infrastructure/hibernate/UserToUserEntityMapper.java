package me.team.usercrud.user.infrastructure.hibernate;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.User;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntityMapper implements Mapper<User, UserEntity> {

    private final Mapper<UserEntity, User> mapper;

    public UserToUserEntityMapper(Mapper<UserEntity, User> mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserEntity from(@NonNull User fromType) {
        return mapper.to(fromType);
    }

    @Override
    public User to(@NonNull UserEntity toType) {
        return mapper.from(toType);
    }
}
