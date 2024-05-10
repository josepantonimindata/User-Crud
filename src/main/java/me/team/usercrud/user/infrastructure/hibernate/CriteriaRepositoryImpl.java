package me.team.usercrud.user.infrastructure.hibernate;

import jakarta.persistence.EntityManager;
import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.CriteriaRepository;
import me.team.usercrud.shared.infrastructure.hibernate.CriteriaConverter;
import me.team.usercrud.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CriteriaRepositoryImpl implements CriteriaRepository<User> {
    
    private final EntityManager em;
    private final CriteriaConverter<UserEntity> userCriteriaConverter;
    private final Mapper<UserEntity, User> entityUserMapper;
    
    public CriteriaRepositoryImpl(EntityManager em, Mapper<UserEntity, User> entityUserMapper) {
        this.em = em;
        userCriteriaConverter = new CriteriaConverter<>(em.getCriteriaBuilder());
        this.entityUserMapper = entityUserMapper;
    }
    
    @NonNull
    @Override
    public List<User> search(@NonNull Criteria criteria) {
        var criteriaQuery = userCriteriaConverter.convert(criteria, UserEntity.class);
        
        var query = em.createQuery(criteriaQuery);
        
        criteria.offset().ifPresent(query::setFirstResult);
        criteria.limit().ifPresent(query::setMaxResults);
        
        return query.getResultList().stream().map(entityUserMapper::map).toList();
    }
    
    @Override
    public Page<User> search(@NonNull Criteria criteria, Pageable pageable) {
    
    }
}
