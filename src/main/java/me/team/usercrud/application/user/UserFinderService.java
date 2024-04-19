package me.team.usercrud.application.user;

import org.springframework.stereotype.Service;

import java.util.UUID;

public interface UserFinderService {
    void findUser(UUID userID);

    void findAll();
}
