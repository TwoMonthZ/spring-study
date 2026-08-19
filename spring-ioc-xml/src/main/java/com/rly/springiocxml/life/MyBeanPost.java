package com.rly.springiocxml.life;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("3在bean初始化之前执行");
        System.out.println(beanName+" "+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("5在bean初始化之后执行");
        System.out.println(beanName+" "+bean);
        return bean;
    }
}
