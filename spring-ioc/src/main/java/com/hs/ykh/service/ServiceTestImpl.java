package com.hs.ykh.service;

import com.hs.ykh.annotation.Autowired;
import com.hs.ykh.annotation.Bean;
import com.hs.ykh.dao.DaoTest;

@Bean
public class ServiceTestImpl implements ServiceTest{

    @Autowired
    private DaoTest daoTest;

    @Override
    public void test() {
        System.out.println("我是service的方法");
        daoTest.method();
    }
}
