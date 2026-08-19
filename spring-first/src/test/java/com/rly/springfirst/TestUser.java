package com.rly.springfirst;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestUser {

    //创建Logger对象
    private Logger log = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        User user = (User) context.getBean("user");
        System.out.println(user);

        user.add();
        log.info("执行调用成功了");

    }

    @Test
    public void testUserObject1() throws Exception {
        Class<?> clazz = Class.forName("com.rly.springfirst.User");
        //Object o = clazz.newInstance();
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);

    }



}
