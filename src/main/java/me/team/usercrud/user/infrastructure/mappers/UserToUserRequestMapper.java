package me.team.usercrud.user.infrastructure.mappers;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserToUserRequestMapper implements Mapper<User, UserRequest> {
    
    private final Mapper<UserRequest, User> mapper;
    
    public UserToUserRequestMapper(Mapper<UserRequest, User> mapper) {
        this.mapper = mapper;
    }
    
    @Override
    public UserRequest from(@NonNull User fromType) {
        return mapper.to(fromType);
    }
    
    @Override
    public User to(@NonNull UserRequest toType) {
        return mapper.from(toType);
    }
}
