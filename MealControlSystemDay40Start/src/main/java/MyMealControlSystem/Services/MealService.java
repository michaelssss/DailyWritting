package MyMealControlSystem.Services;

import MyMealControlSystem.BaseService.Service;
import MyMealControlSystem.POJO.MealEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by michaelssss on 16-2-12.
 */
@org.springframework.stereotype.Service
public class MealService {
    @Autowired
    private Service service;

    public MealEntity queryOne(String code) {
        MealEntity mealEntity = service.query(MealEntity.class, code);
        return mealEntity;
    }

    public List<MealEntity> queryAll() {
        return service.query(MealEntity.class);
    }

    public void saveAll(List<MealEntity> list) {
        service.save(list);
    }
}
