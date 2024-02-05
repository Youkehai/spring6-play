import com.hs.ykh.CustomClass;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomClass {

    @Test
    public void testLoadCustomClass(){
        //1.加载spring配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.通过xml中定义的id获取对应的bean
        CustomClass customClass = (CustomClass)applicationContext.getBean("customClass");
        //使用对象调用方法
        customClass.testMethod();
    }
}
