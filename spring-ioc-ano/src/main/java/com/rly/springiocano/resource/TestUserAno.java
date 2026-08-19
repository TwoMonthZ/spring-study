package com.rly.springiocano.resource;

import com.rly.springiocano.config.SpringConfig;
import com.rly.springiocano.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class TestUserAno {
    static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserController userController = context.getBean("myUserController", UserController.class);

        userController.add();
    }
}
