package me.team.usercrud.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void deleteById(UUID userID);
    Optional<User> findById(UUID id);
    List<User> findAll();
    User save(User user);
    boolean existsById(UUID userId);
}
