package me.team.usercrud.user.infrastructure.hibernate;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.hibernate.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntityMapper implements Mapper<User, UserEntity> {

    private final Mapper<UserEntity, User> mapper;

    public UserToUserEntityMapper(Mapper<UserEntity, User> mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserEntity from(User fromType) {
        return mapper.to(fromType);
    }

    @Override
    public User to(UserEntity toType) {
        return mapper.from(toType);
    }
}