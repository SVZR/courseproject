package by.itacademy.dao;

import by.itacademy.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CountryDao extends BaseDao<Country> {

    @Override
    protected Class<Country> getEntityClass() {
        return Country.class;
    }

    public Country findFullInfo(long countryId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = session.createQuery("select c from Country c join fetch c.themes t join fetch t.series s join fetch s.coins where c.id = :countryId", Country.class)
                .setParameter("countryId", countryId)
                .getSingleResult();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return country;
    }
}
