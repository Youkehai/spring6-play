package com.hs.ykh.dao;

import com.hs.ykh.annotation.Bean;

@Bean
public class DaoTestImpl implements DaoTest{
    @Override
    public void method() {
        System.out.println("我是dao的方法");
    }
}
