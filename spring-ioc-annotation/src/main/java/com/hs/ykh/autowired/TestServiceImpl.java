package com.hs.ykh.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    /**
     * 自动装配
     */
    @Autowired
    private TestDao testDao;

    @Override
    public void method() {
        System.out.println("调用了service的方法");
        testDao.method();
    }
}
