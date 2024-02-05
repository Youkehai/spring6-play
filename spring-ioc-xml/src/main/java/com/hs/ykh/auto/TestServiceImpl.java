package com.hs.ykh.auto;

public class TestServiceImpl implements TestService{

    /**
     * 自动装配
     */
    private TestDao testDao;
    /**
     * 自动装配底层是spring利用反射调用了属性的set方法，所以必须提供set方法，不然会无法自动注入属性
     * @param testDao
     */
    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public void method() {
        System.out.println("调用了service的方法");
        testDao.method();
    }
}
