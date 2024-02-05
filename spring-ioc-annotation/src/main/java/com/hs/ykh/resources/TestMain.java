package com.hs.ykh.resources;

import com.hs.ykh.autowired.TestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        TestController2 testController = (TestController2)classPathXmlApplicationContext.getBean("testController2");
        testController.method();
    }
}
