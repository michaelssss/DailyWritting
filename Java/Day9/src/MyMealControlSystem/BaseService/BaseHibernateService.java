package MyMealControlSystem.BaseService;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by michaelssss on 16-1-11.
 */
public class BaseHibernateService<T> {
    public void create(T object) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void update(T object) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void delete(T object) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public T query(Class<? extends T> clazz, Serializable id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            return session.get(clazz, id);
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<T> list(String hql) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            return session.createQuery(hql).list();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}
