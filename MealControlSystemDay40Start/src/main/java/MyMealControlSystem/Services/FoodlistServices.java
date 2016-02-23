package MyMealControlSystem.Services;

import MyMealControlSystem.BaseService.Service;
import MyMealControlSystem.POJO.FoodlistEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelssss on 16-2-16.
 */
@org.springframework.stereotype.Service
public class FoodlistServices {
    @Autowired
    private Service service;

    public List<FoodlistEntity> queryAll() {
        return service.query(FoodlistEntity.class);
    }

    public FoodlistEntity findOne(int code) {
        return service.query(FoodlistEntity.class, code);
    }

    public void saveOne(FoodlistEntity foodlistEntity) {
        List<FoodlistEntity> list = new ArrayList<FoodlistEntity>();
        list.add(foodlistEntity);
        service.save(list);
    }

    public void deleteOne(FoodlistEntity foodlistEntity) {
        service.delete(foodlistEntity);
    }
}
