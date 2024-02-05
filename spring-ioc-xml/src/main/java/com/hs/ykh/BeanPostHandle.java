package com.hs.ykh;

import com.hs.ykh.life.LifeCycle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义的bean后置处理器
 * 需要注入到IOC中才有效
 */
public class BeanPostHandle implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycle){
            System.out.println("第三步，调用后置处理器，在调用初始化方法之前");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycle){
            System.out.println("第五步，调用后置处理器，处理初始化之后的类");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

}
