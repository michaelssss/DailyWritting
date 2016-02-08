package MyMealControlSystem.BaseService;

import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ISerivce {
    private SessionFactory sessionFactory;

    public Service() {
        System.out.println("Init Service");
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <E> E query(Class<E> e, Serializable code) {
        sessionFactory.getCurrentSession().beginTransaction();

        E object = sessionFactory.getCurrentSession().get(e, code);

        sessionFactory.getCurrentSession().getTransaction().commit();

        return object;
    }

    public void delete(String code) {

        sessionFactory.getCurrentSession().beginTransaction();

        sessionFactory.getCurrentSession().delete(code);

        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public <E> void delete(E Object) {
        sessionFactory.getCurrentSession().beginTransaction();

        sessionFactory.getCurrentSession().delete(Object);

        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public void excute(String sql) {

        sessionFactory.getCurrentSession().createSQLQuery(sql);
    }

    public void save(List<?> list) {

        sessionFactory.getCurrentSession().beginTransaction();

        for (Object o : list) {
            sessionFactory.getCurrentSession().save(o);
        }
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    public <E> List<E> query(Class<E> e) {

        return sessionFactory.getCurrentSession().createCriteria(e).list();
    }
}
