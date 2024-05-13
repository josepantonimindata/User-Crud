package me.team.usercrud.user.application.criteria;

import me.team.usercrud.user.application.exceptions.IllegalCriteriaArgumentsException;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.CriteriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserCriteriaServiceTest {
    
    @Test
    void testSearch() {
        CriteriaRepository<User> mockRepo = mock(CriteriaRepository.class);
        UserCriteriaService service = new UserCriteriaService(mockRepo);

        User testUser = mock(User.class);
        List<User> users = Arrays.asList(testUser, testUser, testUser);

        Criteria criteria = Criteria.none();
        when(mockRepo.search(criteria)).thenReturn(users);

        List<User> result = service.search(criteria);

        assertThat(result).isEqualTo(users);
        verify(mockRepo, times(1)).search(criteria);
    }

    @Test
    void testSearchThrowsIllegalCriteriaArgumentsException() {
        CriteriaRepository<User> mockRepo = mock(CriteriaRepository.class);
        UserCriteriaService service = new UserCriteriaService(mockRepo);

        Criteria criteria = Criteria.none();
        when(mockRepo.search(criteria)).thenThrow(RuntimeException.class);

        assertThrows(IllegalCriteriaArgumentsException.class, () -> service.search(criteria));
        verify(mockRepo, times(1)).search(criteria);
    }
    @Test
    void testSearchWithPageable() {
        CriteriaRepository<User> mockRepo = mock(CriteriaRepository.class);
        UserCriteriaService service = new UserCriteriaService(mockRepo);

        User testUser = mock(User.class);
        Page<User> users = new PageImpl<>(Arrays.asList(testUser, testUser, testUser));
        Pageable pageable = PageRequest.of(0, 3);

        Criteria criteria = Criteria.none();
        when(mockRepo.search(criteria, pageable)).thenReturn(users);

        Page<User> result = service.search(criteria, pageable);

        assertThat(result).isEqualTo(users);
        verify(mockRepo, times(1)).search(criteria, pageable);
    }
    
    @Test
    void testSearchWithPageableThrowsIllegalCriteriaArgumentsException() {
        CriteriaRepository<User> mockRepo = mock(CriteriaRepository.class);
        UserCriteriaService service = new UserCriteriaService(mockRepo);

        Criteria criteria = Criteria.none();
        Pageable pageable = PageRequest.of(0, 3);
        when(mockRepo.search(criteria, pageable)).thenThrow(RuntimeException.class);

        assertThrows(IllegalCriteriaArgumentsException.class, () -> service.search(criteria, pageable));
        verify(mockRepo, times(1)).search(criteria, pageable);
    }
}
