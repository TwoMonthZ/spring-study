package com.rly.springiocxml.auto;

import com.rly.springiocxml.User;
import com.rly.springiocxml.auto.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");

        UserController userController = context.getBean("userController", UserController.class);

        userController.addUser();
    }
}
