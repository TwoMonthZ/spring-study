package com.rly.springaop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回代理对象
    public Object getProxy(){
        /**
         * Proxy.newProxyInstance()方法的参数
         * 1. 类加载器 ClassLoader loader 加载动态生成代理类的类加载器
         * 2. 接口 Class<?>[] interfaces 代理对象实现的所有接口，class类型数组
         * 3. 代理对象 InvocationHandler handler 设置代理对象实现目标对象方法的过程
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            //1.代理对象
            //2.重写目标对象方法
            //3.参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //方法调用之前输出
                System.out.println("方法调用之前输出");
                //方法调用
                Object result = method.invoke(target, args);
                //方法调用之后输出
                System.out.println("方法调用之后输出");
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, handler );
    }
}
