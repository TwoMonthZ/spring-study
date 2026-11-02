package com.rly.springreflect.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderService.class);
        enhancer.setCallback(new MyMethodInterceptor());

        OrderService proxy = (OrderService) enhancer.create();
        proxy.createOrder("NO123456");
    }
}
