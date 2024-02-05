import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {

    @Test
    public void jdbc(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("jdbc.xml");
        DruidDataSource bean = classPathXmlApplicationContext.getBean(DruidDataSource.class);
        System.out.println(bean.getUrl());
    }
}
