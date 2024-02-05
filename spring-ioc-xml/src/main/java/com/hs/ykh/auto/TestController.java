package com.hs.ykh.auto;

public class TestController {

    /**
     * 使用自动装配，装配testService属性
     */
    private TestService testService;

    /**
     * 自动装配底层是spring利用反射调用了属性的set方法，所以必须提供set方法，不然会无法自动注入属性
     * @param testService
     */
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public void method(){
        testService.method();
    }
}
