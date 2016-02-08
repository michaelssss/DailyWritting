import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class Main1 {


    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory((new ClassPathResource("applicationContext.xml")));
        ISerivce service = (ISerivce) factory.getBean("service");
        service.serivce();
        factory.destroySingletons();
    }
}