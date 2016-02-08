import MyMealControlSystem.POJO.MealEntity;
import Utils.HibernateUtils;
import org.hibernate.Session;

import java.sql.Timestamp;


public class Service implements ISerivce {
    private HibernateUtils hibernateUtils;

    public HibernateUtils getHibernateUtils() {
        return hibernateUtils;
    }

    public void setHibernateUtils(HibernateUtils hibernateUtils) {
        this.hibernateUtils = hibernateUtils;
    }

    @Override
    public void serivce() {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            MealEntity meal = new MealEntity();
            meal.setCategory(1);
            meal.setTimestamp(new Timestamp(System.currentTimeMillis()));
            meal.setVolume(0.2);
            session.persist(meal);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
