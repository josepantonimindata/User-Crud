package me.team.usercrud.user.application.crud;

import me.team.usercrud.user.application.exceptions.UserAlreadyExistsException;
import me.team.usercrud.user.domain.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserCreateServiceTest {

    private final UserRepository userRepositoryMock = mock(UserRepository.class);
    private final UserCreateService service = new UserCreateService(userRepositoryMock);

    @Test
    void shouldCreateUser() {
        UserId testId = new UserId("6635d2ad-9df0-4d3f-8c00-9814f7a32006");
        UserName testName = new UserName("testName");
        UserSurname testSurname = new UserSurname("testSurname");
        UserEmail testEmail = new UserEmail("testEmail@test.com");
        UserPassword testPassword = new UserPassword("testPassword");
        User testUser = User.create(testId, testName, testSurname, testEmail, testPassword);

        when(userRepositoryMock.existsById(testUser.id())).thenReturn(false);
        when(userRepositoryMock.save(testUser)).thenReturn(testUser);

        User result = service.createUser(testId, testName, testSurname, testEmail, testPassword);

        verify(userRepositoryMock, times(1)).existsById(testUser.id());
        verify(userRepositoryMock, times(1)).save(testUser);

        assertEquals(testUser, result);
    }

    @Test
    void shouldThrowExceptionWhenUserAlreadyExists() {
        UserId testId = new UserId("693fb1f2-82d7-4bcf-9640-afd87a462518");
        UserName testName = new UserName("testName");
        UserSurname testSurname = new UserSurname("testSurname");
        UserEmail testEmail = new UserEmail("testEmail@test.com");
        UserPassword testPassword = new UserPassword("testPassword");
        User testUser = User.create(testId, testName, testSurname, testEmail, testPassword);

        when(userRepositoryMock.existsById(testUser.id())).thenReturn(true);

        assertThrows(UserAlreadyExistsException.class, () -> service.createUser(testId, testName, testSurname, testEmail, testPassword));

        verify(userRepositoryMock, times(1)).existsById(testUser.id());
    }

}
