package com.hs.ykh.resources;

import com.hs.ykh.autowired.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService3")
public class TestServiceImpl2 implements TestService2 {

    /**
     * 自动装配
     */
    @Autowired
    private TestDao testDao;

    @Override
    public void method() {
        System.out.println("调用了resource注入的-service的方法");
        testDao.method();
    }
}
