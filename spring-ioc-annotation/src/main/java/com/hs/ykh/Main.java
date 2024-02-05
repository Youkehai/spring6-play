package com.hs.ykh;

import com.hs.ykh.test.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        User bean = classPathXmlApplicationContext.getBean(User.class);
        bean.run();

    }
}