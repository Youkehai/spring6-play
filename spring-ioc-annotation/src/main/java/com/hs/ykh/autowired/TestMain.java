package com.hs.ykh.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        TestController testController = (TestController)classPathXmlApplicationContext.getBean("testController");
        testController.method();
    }
}
