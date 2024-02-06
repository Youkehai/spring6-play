package com.hs.ykh.bean;

/**
 * 创建Bean容器的接口
 */
public interface ApplicationContext {

    Object getBean(Class<?> clazz);

}
