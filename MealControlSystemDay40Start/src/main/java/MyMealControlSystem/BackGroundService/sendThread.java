package MyMealControlSystem.BackGroundService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by michaelssss on 16-2-8.
 */
public class sendThread implements Runnable {
    private String Content;

    public sendThread(String content) {
        this.Content = content;
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
        try {
            this.send(this.Content);
        } catch (Exception e) {

        }
    }
}
