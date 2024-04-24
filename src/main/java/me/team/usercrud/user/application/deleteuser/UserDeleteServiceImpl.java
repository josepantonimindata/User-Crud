package me.team.usercrud.user.application.deleteuser;

import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;
import me.team.usercrud.user.domain.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserDeleteServiceImpl implements UserDeleteService {
    private final UserRepository userRepository;

    public UserDeleteServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUserById(UserId id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);
    }
}
