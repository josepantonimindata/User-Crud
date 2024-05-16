package me.team.usercrud.user.infrastructure.hibernate.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.hibernate.UserEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntity implements Mapper<User, UserEntity> {
    @NonNull
    @Override
    public UserEntity map(@NonNull User user) {
        return new UserEntity(
            user.id().value(),
            user.name().value(),
            user.surname().value(),
            user.email().value(),
            user.password().value(),
            user.lastEditTime().value(),
            user.lastEditTime().value()
        );
    }
    
}
