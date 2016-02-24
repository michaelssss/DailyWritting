package MyMealControlSystem.Aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by michaelssss on 16-2-23.
 */
@Component
@Aspect
public class identifyUser {
    @Autowired
    private HttpSession session;

    @Around("execution(* MyMealControlSystem.Controller.*.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Use Controller = " + joinPoint.getTarget().getClass().getName());
        if (session.getAttribute("username") == null) {
            System.out.println("未授权使用");
            return "redirect:/index";
        }
        return joinPoint.proceed();
    }
}
