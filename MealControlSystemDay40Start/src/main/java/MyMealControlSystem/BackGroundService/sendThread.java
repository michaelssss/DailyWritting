package MyMealControlSystem.BackGroundService;

import MyMealControlSystem.POJO.MealEntity;
import MyMealControlSystem.Services.MealService;
import org.springframework.web.context.WebApplicationContext;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * Created by michaelssss on 16-2-8.
 */
public class sendThread implements Runnable {

    private MealService service;

    public sendThread(WebApplicationContext ctx) {
        this.service = (MealService) ctx.getBean("mealService");
        ;
    }

    private void send(String content) throws MessagingException {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "false");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp-ent.21cn.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 设置环境信息
        Session session = Session.getInstance(props);

        Message message = new MimeMessage(session);
        message.setSubject("定时发送");
        message.setText(content);
        message.setFrom(new InternetAddress("lym@cndatacom.com"));

        Transport transport = session.getTransport();
        transport.connect("lym@cndatacom.com", "liangyuming2@");
        transport.sendMessage(message, new Address[]{new InternetAddress("lym@cndatacom.com")});
        transport.close();
    }

    public void run() {
        System.out.println("邮件服务已经成功启动");
        List<MealEntity> list = service.queryAll();
        StringBuilder stringBuilder = new StringBuilder();

        long count = 0;
        while (true) {
            try {
                //每周发送一次
                Thread.sleep(Timer.getHours() * 24 * 7);
                count += 5;
                System.out.println("已经过去了：" + count + " 天");
                for (MealEntity mealEntity : list) {
                    stringBuilder.append(mealEntity.toString() + "\n");
                    System.out.println(mealEntity);
                }
                this.send(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                System.out.println("已经发送测试邮件：" + count / 5 + "封");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
