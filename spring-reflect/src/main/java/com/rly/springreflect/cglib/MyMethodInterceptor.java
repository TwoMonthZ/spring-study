package com.rly.springreflect.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法执行前：" + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("方法执行后：" + method.getName());
        return result;
    }
}
