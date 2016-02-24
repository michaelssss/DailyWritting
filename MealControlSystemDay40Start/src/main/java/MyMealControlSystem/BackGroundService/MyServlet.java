package MyMealControlSystem.BackGroundService;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by michaelssss on 16-2-8.
 */
public class MyServlet extends HttpServlet {


    public void init(ServletConfig servletConfig) throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        System.out.println("后台服务启动");
        new Thread(new sendThread(ctx)).start();
        FoodListCache foodListCache = (FoodListCache) ctx.getBean("foodListCache");
        foodListCache.load();
    }
}

