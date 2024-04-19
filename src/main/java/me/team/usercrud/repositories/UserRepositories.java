package me.team.usercrud.repositories;

import me.team.usercrud.domain.User;
import org.springframework.data.repository.Repository;

public interface UserRepositories extends Repository<User, Long> {
}
