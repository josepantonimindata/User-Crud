package me.team.usercrud.domain.criteria;

import me.team.usercrud.user.domain.User;
import me.team.usercrud.domain.UserFactory;
import me.team.usercrud.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public class CriteriaRepositoryIntegrationTests {

    @Autowired
    private CriteriaRepository<User> criteriaRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void empty() {
        var user = UserFactory.random();
        userRepository.save(user);

        var users = criteriaRepository.search(CriteriaFactory.empty());

        assertEquals(List.of(user), users);
    }

    @Test
    public void ordered() {
        var expectedUsers = UserFactory.randomList(5);
        for (User user : expectedUsers) {
            userRepository.save(user);
        }

        var users = criteriaRepository.search(CriteriaFactory.asc("name"));

        expectedUsers.sort(Comparator.comparing(User::getName));

        assertEquals(expectedUsers, users);
    }

    @Test
    public void singleFilter() {
        var userJohn = UserFactory.named("John");
        var userJane = UserFactory.named("Jane");

        userRepository.save(userJohn);
        userRepository.save(userJane);

        var users = criteriaRepository.search(CriteriaFactory.contains("name", userJohn.getName()));

        assertEquals(1, users.size());
        assertEquals(userJohn, users.getFirst());
    }

    @Test
    public void multipleFilters() {
        var userJohn = UserFactory.named("John");
        var userJane = UserFactory.named("Jane");
        var userBob = UserFactory.named("Bob");

        userRepository.save(userJohn);
        userRepository.save(userJane);
        userRepository.save(userBob);

        var complexCriteria = new Criteria(
            new Filters(
                List.of(new Filter(new FilterField("name"), FilterOperator.CONTAINS, new FilterValue(userJane.getName())),
                    new Filter(new FilterField("email"), FilterOperator.EQUAL, new FilterValue(userJane.getEmail())))
            ),
            Order.asc("name")
        );

        var users = criteriaRepository.search(complexCriteria);

        assertEquals(1, users.size());
        assertEquals(userJane, users.getFirst());
    }
}
