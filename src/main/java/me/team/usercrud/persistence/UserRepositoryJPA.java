package me.team.usercrud.persistence;

import me.team.usercrud.user.domain.User;
import me.team.usercrud.domain.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositoryJPA extends UserRepository, CrudRepository<User, UUID> {
}
