package me.team.usercrud.user.application.crud;

import me.team.usercrud.user.application.exceptions.UserAlreadyExistsException;
import me.team.usercrud.user.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserCreateService {
    private final UserRepository userRepository;
    
    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(UserId id, UserName name, UserSurname surname, UserEmail email, UserPassword password) {
        var user = User.create(id, name, surname, email, password);
        if (userRepository.existsById(user.id())) {
            throw new UserAlreadyExistsException(user);
        }
        return userRepository.save(user);
    }
}
