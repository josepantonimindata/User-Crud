package me.team.usercrud.application.users;

import me.team.usercrud.user.domain.User;
import me.team.usercrud.domain.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryInMemory implements UserRepository {
    private List<User> users = List.of(
            new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c1"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1"),
            new User(UUID.fromString("fe3ad44e-2b84-4d11-9f35-8e570ff3d3e2"), "Josep Antoni", "Aguilo", "josep@josep.com", "somehash2"),
            new User(UUID.fromString("9a493853-0650-4b7c-a748-6c1096f5a97d"), "Esteve", "Llobera", "esteve@esteve.com", "somehash3")
    );

    @Override
    public void deleteById(UUID userID) {
        // No need to throw an exception if the user does not exist
    }

    @Override
    public Optional<User> findById(UUID userID) {
        try {
            return users.stream().filter(user -> user.getId().equals(userID)).findFirst();
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User save(User user) {
        return user;
    }

    @Override
    public boolean existsById(UUID userId) {
        return users.stream().anyMatch(user -> user.getId().equals(userId));
    }
}
