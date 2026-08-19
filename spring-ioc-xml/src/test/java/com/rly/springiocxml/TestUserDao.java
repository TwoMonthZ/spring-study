package com.rly.springiocxml;

import com.rly.springiocxml.bean.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        UserDao bean = context.getBean(UserDao.class);

        bean.run();
        System.out.println(bean);
    }
}
