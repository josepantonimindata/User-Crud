package me.team.usercrud.persistence;

import me.team.usercrud.domain.User;
import me.team.usercrud.domain.UserRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends UserRepository, CrudRepository<User, UUID> {
}
