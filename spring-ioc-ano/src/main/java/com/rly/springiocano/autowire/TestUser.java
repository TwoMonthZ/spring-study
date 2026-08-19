package com.rly.springiocano.autowire;

import com.rly.springiocano.autowire.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        UserController userController = context.getBean("userController", UserController.class);

        userController.add();
    }
}
