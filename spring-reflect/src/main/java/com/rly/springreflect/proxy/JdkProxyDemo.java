package com.rly.springreflect.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Proxy;

public class JdkProxyDemo {
    static void main(String[] args) {
        UserService target = new UserServiceImpl();

        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHanler(target)
        );

        proxy.save("张三");

    }
}
