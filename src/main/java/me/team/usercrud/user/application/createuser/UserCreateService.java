package me.team.usercrud.user.application.createuser;

import me.team.usercrud.user.domain.*;

public interface UserCreateService {
    User createUser(String userId, String userName, String userSurname, String userEmail, String userPassword);
}
