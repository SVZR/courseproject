package by.itacademy.dao;

import by.itacademy.entity.Coin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CoinDao extends BaseDao<Coin> {
    @Override
    protected Class<Coin> getEntityClass() {
        return Coin.class;
    }

    public List<Coin> findCoinsByCountryId(long countryId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Coin> resultList = session.createQuery("select c from Coin c where c.series.theme.country.id = :countryId", Coin.class)
                .setParameter("countryId", countryId)
                .getResultList();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return resultList;
    }

    @Override
    public Coin findById(long id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Coin foundObject = session.createQuery("select c from Coin c join fetch c.coinDescriptions"
                + " cd join fetch cd.metal m join fetch c.series s join fetch s.theme t join fetch t.country "
                + "where c.id = :coinId", Coin.class)
                .setParameter("coinId", id)
                .getResultList()
                .get(0);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return foundObject;
    }
}
