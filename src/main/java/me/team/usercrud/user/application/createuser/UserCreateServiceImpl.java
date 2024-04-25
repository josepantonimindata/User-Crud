package me.team.usercrud.user.application.createuser;

import me.team.usercrud.user.application.exceptions.UserAlreadyExistsException;
import me.team.usercrud.user.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserCreateServiceImpl implements UserCreateService {
    private final UserRepository userRepository;

    public UserCreateServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserId id, UserName name, UserSurname surname, UserEmail email, UserPassword password) {
        var user = User.create(id, name, surname, email, password);
        if (userRepository.existsById(user.id())) {
            throw new UserAlreadyExistsException(user);
        }
        return userRepository.save(user);
    }

    @Override
    public User createUser(String userId, String userName, String userSurname, String userEmail, String userPassword) {
        return createUser(
                new UserId(userId),
                new UserName(userName),
                new UserSurname(userSurname),
                new UserEmail(userEmail),
                new UserPassword(userPassword)
        );
    }
}
