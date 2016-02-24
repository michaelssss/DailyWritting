package MyMealControlSystem.Controller.MealController;

import MyMealControlSystem.BackGroundService.FoodListCache;
import MyMealControlSystem.POJO.MealEntity;
import MyMealControlSystem.Services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by michaelssss on 16-2-22.
 */
@Controller
public class ListAllMealRecordController {
    @Autowired
    private MealService service;

    @RequestMapping(value = {"/ListAllMealRecord"})
    public String Main(HttpServletRequest request) {
        List<MealEntity> mealEntityList = service.queryAll();
        request.setAttribute("list", mealEntityList);
        request.setAttribute("cache", FoodListCache.foodlist);
        return "/MealRecord/allmealrecord";
    }

    @RequestMapping(value = {"/ListAllMealRecord/save"}, method = {RequestMethod.POST})
    public String save(HttpServletRequest request) {
        MealEntity object = new MealEntity();
        object.setTimestamp(new Timestamp(Long.valueOf((String) request.getParameter("timestamp"))));
        object.setVolume(Double.valueOf((String) request.getParameter("volume")));
        object.setCategory(Integer.valueOf((String) request.getParameter("category")));
        service.save(object);
        return "redirect:/ListAllMealRecord";
    }
}
