import MyMealControlSystem.POJO.FoodlistEntity;
import MyMealControlSystem.Services.FoodlistServices;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by michaelssss on 16-2-17.
 */
public class MyTest {
    @Test
    public void mytest() {
        FoodlistServices services = (FoodlistServices) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("foodlistServices");
        FoodlistEntity foodlistEntity = new FoodlistEntity();
        foodlistEntity.setUid(0);
        foodlistEntity.setFoodName("测试");
        foodlistEntity.setCalories(200.0);
        foodlistEntity.setType("测试");
        services.saveOne(foodlistEntity);
        Assert.assertEquals(services.findOne(0), foodlistEntity);
        services.deleteOne(foodlistEntity);
    }
}
