package me.team.usercrud.user.infrastructure.hibernate;

import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.user.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryHibernateTest {
    
    @MockBean
    private UserEntityRepository userEntityRepository;
    
    @MockBean
    private Mapper<User, UserEntity> userMapper;
    
    @MockBean
    private Mapper<UserEntity, User> userEntityMapper;
    
    @Test
    public void testDeleteById() {
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        UserId testUserId = new UserId("23dc42fd-ffce-42fe-bd31-f15f3e10f8ae");
        userRepositoryHibernate.deleteById(testUserId);
        verify(userEntityRepository, times(1)).deleteById(testUserId.value());
    }
    
    @Test
    public void testFindById_whenUserPresent() {
        UserEntity anyValidUserEntity = new UserEntity();
        User anyValidUser = User.create(new UserId("477a61f9-a56a-4328-9bcd-7dcb9723a80a"), null, null, null, null);
        Optional<UserEntity> optionalUserEntity = Optional.of(anyValidUserEntity);
        
        when(userEntityRepository.findById("477a61f9-a56a-4328-9bcd-7dcb9723a80a")).thenReturn(optionalUserEntity);
        when(userEntityMapper.map(anyValidUserEntity)).thenReturn(anyValidUser);
        
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        UserId testUserId = new UserId("477a61f9-a56a-4328-9bcd-7dcb9723a80a");
        Optional<User> result = userRepositoryHibernate.findById(testUserId);
        
        assertTrue(result.isPresent());
        assertEquals(anyValidUser, result.get());
    }
    
    @Test
    public void testFindById_whenUserAbsent() {
        when(userEntityRepository.findById("anyValidString")).thenReturn(Optional.empty());
        
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        UserId testUserId = new UserId("e34fe7fc-0a89-46c4-90fd-78611866323b");
        Optional<User> result = userRepositoryHibernate.findById(testUserId);
        
        assertFalse(result.isPresent());
    }
    
    @Test
    public void testFindAll_whenUsersAvailable() {
        List<UserEntity> entities = Arrays.asList(new UserEntity(), new UserEntity());
        List<User> users = Arrays.asList(User.create(new UserId("7f153e96-1805-4c39-bd17-c1d10a749eaa"),
                new UserName("Tom"),
                new UserSurname("Hanks"),
                new UserEmail("tom@hanks.com"),
                new UserPassword("password1")),
            User.create(new UserId("7f153e96-1805-4c39-bd17-c1d10a749eaa"),
                new UserName("John"),
                new UserSurname("Doe"),
                new UserEmail("john@doe.com"),
                new UserPassword("password2")));
        
        when(userEntityRepository.findAll()).thenReturn(entities);
        when(userEntityMapper.map(entities.get(0))).thenReturn(users.get(0));
        when(userEntityMapper.map(entities.get(1))).thenReturn(users.get(1));
        
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        var results = userRepositoryHibernate.findAll();
        
        assertEquals(2, results.size());
        assertTrue(results.containsAll(users));
    }
    
    @Test
    public void testFindAll_whenNoUsersAvailable() {
        when(userEntityRepository.findAll()).thenReturn(new ArrayList<>());
        
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        var results = userRepositoryHibernate.findAll();
        
        assertTrue(results.isEmpty());
    }
    
    @Test
    public void testSave_whenNewUser() {
        User user = User.create(new UserId("e3fd705a-3581-4752-9ad9-ee58afe08a79"),
            new UserName("John"),
            new UserSurname("Doe"),
            new UserEmail("john@doe.com"),
            new UserPassword("password"));
        UserEntity userEntity = new UserEntity();
        UserEntity savedUserEntity = new UserEntity();
        
        when(userMapper.map(user)).thenReturn(userEntity);
        when(userEntityRepository.save(userEntity)).thenReturn(savedUserEntity);
        when(userEntityMapper.map(savedUserEntity)).thenReturn(user);
        
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        User result = userRepositoryHibernate.save(user);
        
        assertEquals(user, result);
    }
    
    @Test
    public void testSave_whenExistingUser() {
        User user = User.create(new UserId("11689714-50c7-4a9a-9748-fca6fd86c76c"),
            new UserName("John"),
            new UserSurname("Doe"),
            new UserEmail("john@doe.com"),
            new UserPassword("password"));
        UserEntity userEntity = new UserEntity();
        UserEntity savedUserEntity = new UserEntity();
        
        when(userMapper.map(user)).thenReturn(userEntity);
        when(userEntityRepository.save(userEntity)).thenReturn(savedUserEntity);
        when(userEntityMapper.map(savedUserEntity)).thenReturn(user);
        
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        User result = userRepositoryHibernate.save(user);
        
        assertEquals(user, result);
    }
    
    @Test
    public void testExistsById_whenUserPresent() {
        when(userEntityRepository.existsById("a852bf43-5095-4863-9be2-bb032263f0c9")).thenReturn(true);
        
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        UserId testUserId = new UserId("a852bf43-5095-4863-9be2-bb032263f0c9");
        boolean exists = userRepositoryHibernate.existsById(testUserId);
        
        assertTrue(exists);
    }
    
    @Test
    public void testExistsById_whenUserAbsent() {
        when(userEntityRepository.existsById("883d8c39-1eb8-4c70-90d2-bf1b86d80370")).thenReturn(false);
        
        UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate(userEntityRepository,
            userMapper,
            userEntityMapper);
        UserId testUserId = new UserId("67aee0f7-0775-40f9-bfba-b933981500b7");
        boolean exists = userRepositoryHibernate.existsById(testUserId);
        
        assertFalse(exists);
    }
}
