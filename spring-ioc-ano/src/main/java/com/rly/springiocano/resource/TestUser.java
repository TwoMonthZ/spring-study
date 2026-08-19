package com.rly.springiocano.resource;

import com.rly.springiocano.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        UserController userController = context.getBean("myUserController", UserController.class);

        userController.add();
    }
}
