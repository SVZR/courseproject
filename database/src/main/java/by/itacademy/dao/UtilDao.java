package by.itacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilDao {

    public static SessionFactory sessionStart() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return sessionFactory;
    }

    public static void sessionClose(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
