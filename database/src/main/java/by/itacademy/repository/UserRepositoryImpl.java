package by.itacademy.repository;

import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepositoryCustom {
    
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Integer findFilteredUsersAmount(Map<String, String> searchFilter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Long> query = entityManager.createQuery("select count(userLogin) from User u" + hqlJoinCollection(searchFilter) + hqlAddFilter(searchFilter), Long.class);
        setQueryParameter(searchFilter, query);
        long result = query.getSingleResult();

        transaction.commit();
        return (int) result;
    }

    @Override
    public List<User> findFilteredUsersOnPage(Map<String, String> searchFilter, int firstUserNumber, int amountUsersOnPage) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<User> query = entityManager.createQuery("select u from User u " + hqlJoinCollection(searchFilter) + hqlAddFilter(searchFilter), User.class);
        setQueryParameter(searchFilter, query);
        query.setFirstResult(firstUserNumber);
        query.setMaxResults(amountUsersOnPage);

        List<User> users = query.getResultList();

        transaction.commit();
        return users;
    }


    private String hqlJoinCollection(Map<String, String> searchFilter) {
        String hql = "";
        if (searchFilter.containsKey("haveCollection")) {
            hql = " join u.collections col where col.amount > 0";
        }
        return hql;
    }

    private String hqlAddFilter(Map<String, String> searchFilter) {
        String hqlFilter = "";
        if (searchFilter.containsKey("haveCollection")) {
            String firstNameHql = "";
            String roleHql = "";
            if (searchFilter.containsKey("firstName")) {
                firstNameHql = " and u.firstName like :firstName";
            }
            if (searchFilter.containsKey("role")) {
                roleHql = " and u.role = :role";
            }
            hqlFilter = firstNameHql + roleHql;
        } else {
            if (searchFilter.containsKey("firstName") && searchFilter.containsKey("role")) {
                hqlFilter = " where u.firstName like :firstName and u.role = :role";
            }
            if (searchFilter.containsKey("firstName") && !searchFilter.containsKey("role")) {
                hqlFilter = " where u.firstName like :firstName";
            }
            if (!searchFilter.containsKey("firstName") && searchFilter.containsKey("role")) {
                hqlFilter = " where u.role = :role";
            }
        }
        return hqlFilter;
    }

    private TypedQuery setQueryParameter(Map<String, String> searchFilter, TypedQuery query) {
        if (searchFilter.containsKey("firstName")) {
            query.setParameter("firstName", "%" + searchFilter.get("firstName") + "%");
        }
        if (searchFilter.containsKey("role")) {
            query.setParameter("role", Role.valueOf(searchFilter.get("role")));
        }
        return query;
    }
}
