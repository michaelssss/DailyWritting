package MyMealControlSystem.Controller;

import MyMealControlSystem.Services.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by michaelssss on 16-2-18.
 */
@Controller
public class IndexController {
    @Resource
    private MealService service;

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
