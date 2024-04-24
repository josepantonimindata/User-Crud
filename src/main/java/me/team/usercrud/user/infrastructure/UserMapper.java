package me.team.usercrud.user.infrastructure;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.*;
import org.springframework.stereotype.Component;

@Component
public final class UserMapper implements Mapper<User, UserEntity> {

    @Override
    public UserEntity from(User user) {
        return new UserEntity(
                user.id().value(),
                user.name().value(),
                user.surname().value(),
                user.email().value(),
                user.password().value()
        );
    }

    @Override
    public User to(UserEntity userEntity) {
        return new User(
                new UserId(userEntity.id()),
                new UserName(userEntity.name()),
                new UserSurname(userEntity.surname()),
                new UserEmail(userEntity.email()),
                new UserPassword(userEntity.password())
        );
    }
}
