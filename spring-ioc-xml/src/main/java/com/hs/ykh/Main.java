package com.hs.ykh;

import com.hs.ykh.containter.BigClass;
import com.hs.ykh.interfacebean.CustomIocInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //根据ID获取bean
        Object customIoc = classPathXmlApplicationContext.getBean("customIoc");
        System.out.println("id获取" + customIoc);
        //根据类型获取bean -- 需要注意，通过类型获取，必须保证该类是单例
        CustomIOC customIoc1 = classPathXmlApplicationContext.getBean(CustomIOC.class);
        System.out.println("类型获取" + customIoc1);
        //id和类型获取
        CustomIOC customIoc2 = classPathXmlApplicationContext.getBean("customIoc", CustomIOC.class);
        System.out.println("id和类型获取" + customIoc2);
        //通过接口类型获取实现类 --- 需要保证实现类唯一，即该接口只能有一个实现类
        CustomIocInterface bean = classPathXmlApplicationContext.getBean(CustomIocInterface.class);
        bean.doSomething();
        //set属性注入
        CustomIOCSet customIOCSet = (CustomIOCSet)classPathXmlApplicationContext.getBean("customIOCSet");
        System.out.println(customIOCSet);
        //构造器注入
        CustomIOCSet customIOCSet2 = (CustomIOCSet)classPathXmlApplicationContext.getBean("customIOCSetCon");
        System.out.println(customIOCSet2);
        //嵌套类注入
        BigClass bigClass = classPathXmlApplicationContext.getBean(BigClass.class);
        System.out.println(bigClass);

    }
}