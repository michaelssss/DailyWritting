package MyMealControlSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by michaelssss on 16-2-18.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("Michaelssss") && password.equals("impossble")) {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
        }
        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
