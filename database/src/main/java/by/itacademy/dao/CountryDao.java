package by.itacademy.dao;

import by.itacademy.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public final class CountryDao {

    private static CountryDao instance;

    private CountryDao() {
    }

    public static CountryDao getInstance() {
        if (instance == null) {
            synchronized (CountryDao.class) {
                if (instance == null) {
                    instance = new CountryDao();
                }
            }
        }
        return instance;
    }

    public void addCountry(String countryName) {
        SessionFactory sessionFactory = UtilDao.sessionStart();
        Session session = sessionFactory.getCurrentSession();

        Country country = new Country();
        country.setName(countryName);
        session.save(country);

        UtilDao.sessionClose(sessionFactory);
    }

    public List<Country> findAll() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Country> countries = session.createQuery("select c from Country c", Country.class).getResultList();
        countries.forEach(c -> System.out.println(c.getName()));

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return countries;
    }
}
