package by.itacademy.dao;

import by.itacademy.entity.Series;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SeriesDao extends BaseDao<Series> {
    @Override
    protected Class<Series> getEntityClass() {
        return Series.class;
    }

    public List<Series> findSeriesByCountryId(long countryId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Series> resultList = session.createQuery("select s from Series s "
                + "where s.theme.country.id = :countryId", Series.class)
                .setParameter("countryId", countryId)
                .getResultList();


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return resultList;
    }
}
