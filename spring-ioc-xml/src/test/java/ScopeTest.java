import com.alibaba.druid.pool.DruidDataSource;
import com.hs.ykh.scope.ScopeCustom;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean-scope.xml");
        //多实例对象，每个内存地址都不一样，只有获取bean时，才会去创建，所以地址不一样
        Object scopeProperty = classPathXmlApplicationContext.getBean("scopeProperty");
        Object scopeProperty2 = classPathXmlApplicationContext.getBean("scopeProperty");
        Object scopeProperty3 = classPathXmlApplicationContext.getBean("scopeProperty");
        System.out.println("多实例"+scopeProperty3);
        System.out.println("多实例"+scopeProperty2);
        System.out.println("多实例"+scopeProperty);
        //单实例，每个内存地址都一样，初始化启动时就会创建
        Object scopeCustom1 = classPathXmlApplicationContext.getBean("scopeCustom");
        Object scopeCustom2 = classPathXmlApplicationContext.getBean("scopeCustom");
        Object scopeCustom3 = classPathXmlApplicationContext.getBean("scopeCustom");
        System.out.println("单实例"+scopeCustom1);
        System.out.println("单实例"+scopeCustom2);
        System.out.println("单实例"+scopeCustom3);
    }
}
