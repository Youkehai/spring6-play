package com.hs.ykh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration//标识该类为一个配置类
@ComponentScan("com.hs.ykh") //开启扫描
public class SpringConfig {
}
