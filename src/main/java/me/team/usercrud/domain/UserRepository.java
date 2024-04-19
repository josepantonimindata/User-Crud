package me.team.usercrud.domain;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    void deleteById(UUID userID);
    User find(UUID userID);
    List<User> findAll();
    User save(User user);
    boolean existsById(UUID userId);
}
