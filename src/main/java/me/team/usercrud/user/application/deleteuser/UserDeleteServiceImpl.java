package me.team.usercrud.user.application.deleteuser;

import lombok.AllArgsConstructor;
import me.team.usercrud.user.application.deleteuser.UserDeleteService;
import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;
import me.team.usercrud.user.domain.UserRepository;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserDeleteServiceImpl implements UserDeleteService {
    private UserRepository userRepository;

    @Override
    public void deleteUserById(UserId id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);
    }

    @Override
    public void deleteUser(User user) {
        final var userId = user.id();
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }

        userRepository.deleteById(userId);
    }
}
