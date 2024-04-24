package me.team.usercrud.user.infrastructure.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.*;
import me.team.usercrud.user.infrastructure.hibernate.UserEntity;
import org.springframework.stereotype.Component;

@Component
public final class UserEntityToUser implements Mapper<UserEntity, User> {


    @Override
    public User from(UserEntity userEntity) {
        return new User(
            new UserId(userEntity.id()),
            new UserName(userEntity.name()),
            new UserSurname(userEntity.surname()),
            new UserEmail(userEntity.email()),
            new UserPassword(userEntity.password()),
            new UserCreationTime(userEntity.creationTime()),
            new UserLastEditTime(userEntity.lastEditTime())
        );
    }

    @Override
    public UserEntity to(User user) {
        return new UserEntity(
            user.id().value(),
            user.name().value(),
            user.surname().value(),
            user.email().value(),
            user.password().value(),
            user.lastEditTime().stingValue(),
            user.lastEditTime().stingValue()
        );
    }
}
