import POJO.MealEntity;
import Utils.HibernateUtils;
import org.hibernate.Session;

import java.sql.Timestamp;


/**
 * Created by michaelssss on 16-1-13.
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            MealEntity meal = new MealEntity();
            meal.setCategory(1);
            meal.setTimestamp(new Timestamp(System.currentTimeMillis()));
            meal.setVolume(0.1);
            session.save(meal);
        } finally {
            session.close();
        }
    }

}