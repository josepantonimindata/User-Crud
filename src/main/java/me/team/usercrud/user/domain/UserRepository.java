package me.team.usercrud.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void deleteById(UserId userID);

    Optional<User> findById(UserId id);

    List<User> findAll();

    User save(User user);

    boolean existsById(UserId userId);
}
