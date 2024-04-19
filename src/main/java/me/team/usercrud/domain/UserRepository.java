package me.team.usercrud.domain;

import java.util.UUID;

public interface UserRepository {
    void deleteById(UUID userID);
}
