package com.rly.springreflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestCar {

    //1、获取class对象多种方式
    @Test
    public void test1() throws Exception {
        //1、类名.class
        Class clazz = Car.class;
        System.out.println(clazz);
        //2. 对象.getClass()
        Class clazz2 = new Car().getClass();
        System.out.println(clazz2);
        //3. Class.forName("类的全限定名")
        Class clazz3 = Class.forName("com.rly.springreflect.Car");
        System.out.println(clazz3);

        //实例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }
    //2、获取构造方法
    @Test
    public void test2() throws Exception {
        Class clazz = Car.class;
        //1. 获取所有公共构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("方法名称："+constructor.getName()+", 参数个数："+constructor.getParameterCount());
        }
        //2. 获取所有构造方法
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println("方法名称："+constructor.getName()+", 参数个数："+constructor.getParameterCount());
        }

        //指定有参构造创建对象
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        //私有构造方法需要设置访问权限
        constructor1.setAccessible(true);
        Car car = (Car) constructor1.newInstance("比亚迪", 10, "红色");
        System.out.println(car);


    }

    //3、获取属性
    @Test
    public void test3() throws Exception {
        Class clazz = Car.class;
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
        //获取所有公共属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("属性名称："+field.getName()+", 属性类型："+field.getType());
        }
        //获取所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if ("name".equals(field.getName())){
                field.setAccessible(true);
                field.set(car, "比亚迪");
            }
            System.out.println(car);
            System.out.println("属性名称："+field.getName()+",  属性类型："+field.getType());
        }


    }

    //4、获取方法
    @Test
    public void test4() throws Exception {
        Class clazz = Car.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        Car car = (Car) constructor.newInstance("比亚迪", 10, "红色");
        //public 方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("方法名称："+method.getName()+", 参数个数："+method.getParameterCount());
            //执行某个方法
            if ("toString".equals(method.getName())){
                String invoke = (String) method.invoke(car);
                System.out.println("toString方法执行"+invoke);
            }
        }
        System.out.println("-------------------------------");
        //private 方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("方法名称："+method.getName()+", 参数个数："+method.getParameterCount());
            if ("run".equals(method.getName())){
                method.setAccessible(true);
                String invoke = (String) method.invoke(car);
                //这返回是void
                System.out.println("run方法执行"+invoke);
            }
        }
    }

}
