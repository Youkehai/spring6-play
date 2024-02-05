package com.hs.ykh.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean-auto.xml");
        TestController testController = (TestController)classPathXmlApplicationContext.getBean("testController");
        testController.method();
    }
}
