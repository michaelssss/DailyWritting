package MyMealControlSystem.Controller.MealController;

import MyMealControlSystem.POJO.MealEntity;
import MyMealControlSystem.Services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by michaelssss on 16-2-22.
 */
@Controller
public class ListAllMealRecordController {
    @Autowired
    private MealService service;

    @RequestMapping({"/ListAllMealRecord"})
    public String Main(HttpServletRequest request) {
        List<MealEntity> mealEntityList = service.queryAll();
        request.setAttribute("list", mealEntityList);
        return "allmealrecord";
    }
}
