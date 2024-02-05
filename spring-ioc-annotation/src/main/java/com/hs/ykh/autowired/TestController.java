package com.hs.ykh.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    /**
     * 使用Autowired进行属性注入
     */
//    @Autowired
//    private TestService testService;

    /**
     * 第二种使用Autowired进行set注入
     * @param testService
     */
//    @Autowired
//    public void setTestService(TestService testService) {
//        this.testService = testService;
//        System.out.println("使用了set方法注入");
//    }

    /**
     * 第三种使用 Autowired 进行构造器注入
     */
//    @Autowired
//    public TestController(TestService testService) {
//        this.testService=testService;
//        System.out.println("使用了构造器注入");
//    }

    /**
     * 第四种使用 Autowired 进行形参注入
     */
//    public TestController(@Autowired TestService testService) {
//        this.testService=testService;
//        System.out.println("使用了形参注入");
//    }

//    /**
//     * 第五种，只有一个构造器，无注解注入
//     * @param testService
//     */
//    public TestController(TestService testService) {
//        this.testService=testService;
//        System.out.println("使用了单构造器，无注解方式注入");
//    }

    /**
     * 第六种，使用 Autowired 和 Qualifier 注入
     * 如果使用 Autowired 直接注入某个接口，但是这个接口有多个实现类，则会报错，因为 Autowired 是 byType注入的
     * No qualifying bean of type 'com.hs.ykh.autowired.TestService' available: expected single matching bean but found 2: testServiceImpl,testServiceTwoImpl
     * 所以使用 Qualifier 指定具体的实现类注入即可
     * @param testService
     */
    @Qualifier("testServiceTwoImpl")
    @Autowired
    private TestService testService;

    public void method(){
        testService.method();
    }
}
