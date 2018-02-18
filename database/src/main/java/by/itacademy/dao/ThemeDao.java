package by.itacademy.dao;

import by.itacademy.entity.Theme;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ThemeDao extends BaseDao<Theme> {

    @Override
    protected Class<Theme> getEntityClass() {
        return Theme.class;
    }

    public List<Theme> findAllThemesByCountry(long countryId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Theme> resultList = session.createQuery("select t from Theme t "
                + "where t.country.id = :countryId", Theme.class)
                .setParameter("countryId", countryId)
                .getResultList();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return resultList;
    }
}
