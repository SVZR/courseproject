package by.itacademy.dao;

import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class UserDao extends BaseDao<User> {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public Integer findAllUsersAmount() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        long result = session.createQuery("select count(u.id) from User u", Long.class).getSingleResult();

        session.getTransaction().commit();
        session.close();
        return (int) result;
    }

    public List<User> findAllUsersOnPage(int firstUserNumber, int amountUsersOnPage) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        List<User> users = session.createQuery("select u from User u", User.class)
                .setFirstResult(firstUserNumber)
                .setMaxResults(amountUsersOnPage)
                .getResultList();

        session.getTransaction().commit();
        session.close();
        return users;
    }

    public Integer findFilteredUsersAmount(Map<String, String> searchFilter) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Query<Long> query = session.createQuery("select count(userLogin) from User u" + hqlJoinCollection(searchFilter) + hqlAddFilter(searchFilter), Long.class);
        setQueryParameter(searchFilter, query);
        long result = query.getSingleResult();

        session.getTransaction().commit();
        session.close();
        return (int) result;
    }

    public List<User> findFilteredUsersOnPage(Map<String, String> searchFilter, int firstUserNumber, int amountUsersOnPage) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Query<User> query = session.createQuery("select u from User u " + hqlJoinCollection(searchFilter) + hqlAddFilter(searchFilter), User.class);
        setQueryParameter(searchFilter, query);
        query.setFirstResult(firstUserNumber);
        query.setMaxResults(amountUsersOnPage);

        List<User> users = query.getResultList();

        session.getTransaction().commit();
        session.close();
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

    private Query setQueryParameter(Map<String, String> searchFilter, Query query) {
        if (searchFilter.containsKey("firstName")) {
            query.setParameter("firstName", "%" + searchFilter.get("firstName") + "%");
        }
        if (searchFilter.containsKey("role")) {
            query.setParameter("role", Role.valueOf(searchFilter.get("role")));
        }
        return query;
    }
}
