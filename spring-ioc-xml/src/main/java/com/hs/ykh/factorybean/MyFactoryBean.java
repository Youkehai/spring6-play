package com.hs.ykh.factorybean;

import com.hs.ykh.CustomIOC;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<CustomIOC> {
    @Override
    public CustomIOC getObject() throws Exception {
        return new CustomIOC();
    }

    @Override
    public Class<?> getObjectType() {
        return CustomIOC.class;
    }
}
