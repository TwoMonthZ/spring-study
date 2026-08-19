package com.rly.springiocxml.life;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    void testUser() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");

        User user = context.getBean("user", User.class);
        System.out.println("6bean对象创建完成");
        System.out.println(user);
        System.out.println(user.getName());
        context.close();
    }
}
