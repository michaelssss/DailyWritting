package MyMealControlSystem.BackGroundService;

import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by michaelssss on 16-2-8.
 */
public class MyServlet extends HttpServlet {


    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("后台服务启动");
        sendThread thread = new sendThread();
        thread.setCtx(WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext()));
        new Thread(thread).start();
    }
}

