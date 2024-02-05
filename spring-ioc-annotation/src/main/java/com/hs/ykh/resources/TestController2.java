package com.hs.ykh.resources;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class TestController2 {

    /**
     * Resource 会默认使用byName寻找
     */
    @Resource
    private TestService2 testService2;

    public void method(){
        testService2.method();
    }
}
