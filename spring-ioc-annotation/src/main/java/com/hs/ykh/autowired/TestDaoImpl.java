package com.hs.ykh.autowired;

import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {

    @Override
    public void method() {
        System.out.println("调用了dao的方法");
    }
}
