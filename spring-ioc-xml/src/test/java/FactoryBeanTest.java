import com.hs.ykh.factorybean.MyFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean-factory.xml");
        Object factoryTest = classPathXmlApplicationContext.getBean("factoryTest");
        System.out.println("原始对象类型"+factoryTest.getClass());
//        System.out.println("调用getObject获取到的类型"+factoryTest);
    }
}
