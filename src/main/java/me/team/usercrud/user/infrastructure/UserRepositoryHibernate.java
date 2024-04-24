package me.team.usercrud.user.infrastructure;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.domain.UserId;
import me.team.usercrud.user.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public final class UserRepositoryHibernate implements UserRepository {
    private final UserEntityRepository userEntityRepository;
    private final Mapper<User, UserEntity> userMapper;

    public UserRepositoryHibernate(UserEntityRepository userEntityRepository, Mapper<User, UserEntity> userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void deleteById(UserId userID) {
        userEntityRepository.deleteById(userID.value());
    }

    @Override
    public Optional<User> findById(UserId id) {
        var optionalUserEntity = userEntityRepository.findById(id.value());
        return optionalUserEntity.map(this::userEntityToUser);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (var userEntity: userEntityRepository.findAll()) {
            users.add(userEntityToUser(userEntity));
        }

        return users;
    }

    @Override
    public User save(User user) {
        var savedUserEntity =  userEntityRepository.save(userToUserEntity(user));
        return userEntityToUser(savedUserEntity);
    }

    @Override
    public boolean existsById(UserId userId) {
        return userEntityRepository.existsById(userId.value());
    }

    private User userEntityToUser(UserEntity userEntity) {
        return userMapper.to(userEntity);
    }

    private UserEntity userToUserEntity(User user) {
        return userMapper.from(user);
    }
}
