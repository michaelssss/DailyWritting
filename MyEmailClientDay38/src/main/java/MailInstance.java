import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by michaelssss on 16-2-7.
 */
public class MailInstance {
    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp-ent.21cn.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 设置环境信息
        Session session = Session.getInstance(props);

        Message message = new MimeMessage(session);
        message.setSubject("Test");
        message.setText("From Michaelssss Test");
        message.setFrom(new InternetAddress("lym@cndatacom.com"));

        Transport transport = session.getTransport();
        transport.connect("lym@cndatacom.com", "liangyuming2@");
        transport.sendMessage(message, new Address[]{new InternetAddress("lym@cndatacom.com")});
        transport.close();
    }
}
