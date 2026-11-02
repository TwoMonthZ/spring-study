package com.rly.springreflect.proxy;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class MyInvocationHanler implements InvocationHandler {

    private final Object target;

    public MyInvocationHanler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前：" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("方法执行后：" + method.getName());
        return result;
    }
}
