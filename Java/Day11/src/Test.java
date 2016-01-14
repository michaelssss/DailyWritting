import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by michaelssss on 16-1-14.
 */
public class Test {
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory((new ClassPathResource("applicationContext.xml")));
        IService service = (IService) factory.getBean("service");
        service.service("Fish");
        factory.destroySingletons();
    }
}
