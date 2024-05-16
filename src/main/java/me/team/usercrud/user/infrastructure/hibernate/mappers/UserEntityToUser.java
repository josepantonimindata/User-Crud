package me.team.usercrud.user.infrastructure.hibernate.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.*;
import me.team.usercrud.user.infrastructure.hibernate.UserEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public final class UserEntityToUser implements Mapper<UserEntity, User> {
    @NonNull
    @Override
    public User map(@NonNull UserEntity userEntity) {
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
}
