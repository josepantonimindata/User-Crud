package me.team.usercrud.user.infrastructure;

import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;
import me.team.usercrud.user.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public final class UserRepositorySql implements UserRepository {
    private UserEntityRepository userEntityRepository;

    public UserRepositorySql(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public void deleteById(UserId userID) {
        userEntityRepository.deleteById(userID.value());
    }

    @Override
    public Optional<User> findById(UserId id) {


        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean existsById(UserId userId) {
        return false;
    }
}
