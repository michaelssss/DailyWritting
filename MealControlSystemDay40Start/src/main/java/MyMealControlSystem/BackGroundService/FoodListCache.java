package MyMealControlSystem.BackGroundService;

import MyMealControlSystem.POJO.FoodlistEntity;
import MyMealControlSystem.Services.FoodlistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michaelssss on 16-2-23.
 */
@Component
public class FoodListCache {
    //食物种类信息预先放进缓存
    public static Map<String, FoodlistEntity> foodlist;
    @Autowired
    private FoodlistServices serivce;


    public void load() {
        System.out.println("载入食物种类信息");
        foodlist = new HashMap<String, FoodlistEntity>();
        try {
            List<FoodlistEntity> foodlistEntityList = serivce.queryAll();
            for (FoodlistEntity foodlistEntity : foodlistEntityList) {
                FoodListCache.foodlist.put(String.valueOf(foodlistEntity.getUid()), foodlistEntity);
                System.out.println(foodlistEntity);
            }
            System.out.println("载入成功");
        } catch (Exception e) {
            System.out.println("载入失败");
            e.printStackTrace();
        }
    }
}
