package com.hs.ykh.config;

import com.hs.ykh.autowired.TestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        //直接加载配置类
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestController testController = (TestController)applicationContext.getBean("testController");
        testController.method();
    }
}
