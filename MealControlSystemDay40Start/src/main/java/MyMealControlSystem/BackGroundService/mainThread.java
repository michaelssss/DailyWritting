package MyMealControlSystem.BackGroundService;

import MyMealControlSystem.POJO.MealEntity;
import MyMealControlSystem.Services.MealService;

import java.util.List;

/**
 * Created by michaelssss on 16-2-8.
 */
public class mainThread {
    public mainThread() {
        MealService service = new MealService();
        List<MealEntity> list = service.queryAll();
        StringBuilder stringBuilder = new StringBuilder();

        long count = 0;
        while (true) {
            try {
                System.out.println("Email Service Begin");
                Thread.sleep(Timer.getMins() * 5);
                count += 5;
                System.out.println("已经过去了：" + count + " 分钟");
                for (MealEntity mealEntity : list) {
                    stringBuilder.append(mealEntity.toString() + "\n");
                    System.out.println(mealEntity);
                }
                Thread thread = new Thread(new sendThread(stringBuilder.toString()));
                thread.start();
                stringBuilder = new StringBuilder();
                System.out.println("已经发送测试邮件：" + count / 5 + "封");

            } catch (Exception e) {

            }
        }
    }
}

