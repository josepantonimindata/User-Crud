package me.team.usercrud.user.application.updateuser;

import me.team.usercrud.user.domain.*;

public interface UserUpdateService {
    User updateUser(UserId id, UserName name, UserSurname surname, UserEmail email, UserPassword password);
}
