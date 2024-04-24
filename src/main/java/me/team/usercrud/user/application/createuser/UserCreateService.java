package me.team.usercrud.user.application.createuser;

import me.team.usercrud.user.domain.*;

public interface UserCreateService {
    User createUser(UserId id, UserName name, UserSurname surname, UserEmail email, UserPassword password);
}
