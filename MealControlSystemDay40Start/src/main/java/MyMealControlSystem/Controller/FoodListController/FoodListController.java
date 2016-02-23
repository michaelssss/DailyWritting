package MyMealControlSystem.Controller.FoodListController;

import MyMealControlSystem.POJO.FoodlistEntity;
import MyMealControlSystem.Services.FoodlistServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by michaelssss on 16-2-22.
 */
@Controller
public class FoodListController {
    @Autowired
    private FoodlistServices services;

    @RequestMapping(value = {"/FoodListSetup/save"}, method = {RequestMethod.POST})
    public String save(@ModelAttribute("foodlistEntry") FoodlistEntity foodlistEntity) {
        services.saveOne(foodlistEntity);
        return "redirect:/FoodListSetup";
    }

    @RequestMapping(value = {"/FoodListSetup"})
    public String main(HttpServletRequest request) {
        request.setAttribute("list", services.queryAll());
        return "FoodListSetup/foodlist";
    }
}
