package by.itacademy.dao;

import by.itacademy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDao<T extends BaseEntity> {

    private static final SessionFactory SESSION_FACTORY
            = new Configuration().configure().buildSessionFactory();
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        ParameterizedType parameterizedSuperclass
                = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) parameterizedSuperclass.getActualTypeArguments()[0];
    }

    public Long save(T objectToSave) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Serializable id = session.save(objectToSave);

        session.getTransaction().commit();
        session.close();
        return (Long) id;
    }

    public void update(T objectToSave) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.update(objectToSave);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(long id) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        T objectToDelete = session.get(entityClass, id);
        session.delete(objectToDelete);

        session.getTransaction().commit();
        session.close();
    }

    public T findById(long id) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        T foundObject = session.get(entityClass, id);

        session.getTransaction().commit();
        session.close();
        return foundObject;
    }

    public List<T> findAll() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<T> foundObjects = session
                .createQuery("select e from " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();

        session.getTransaction().commit();
        session.close();
        return foundObjects;
    }

    protected abstract Class<T> getEntityClass();

    protected SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
