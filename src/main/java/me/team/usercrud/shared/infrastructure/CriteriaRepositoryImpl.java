package me.team.usercrud.shared.infrastructure;

import jakarta.persistence.EntityManager;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.CriteriaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CriteriaRepositoryImpl implements CriteriaRepository<User> {

    private final EntityManager em;
    private final CriteriaConverter<User> userCriteriaConverter;

    public CriteriaRepositoryImpl(EntityManager em) {
        this.em = em;
        userCriteriaConverter = new CriteriaConverter<>(em.getCriteriaBuilder());
    }


    @Override
    public List<User> search(Criteria criteria) {
        var criteriaQuery = userCriteriaConverter.convert(criteria, User.class);

        return em.createQuery(criteriaQuery).getResultList();
    }
}