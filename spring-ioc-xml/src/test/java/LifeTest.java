import com.hs.ykh.life.LifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean-life.xml");
        LifeCycle lifecycle = (LifeCycle)classPathXmlApplicationContext.getBean("lifecycle");
        lifecycle.myMethod();
        classPathXmlApplicationContext.close();
    }
}
