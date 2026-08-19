package com.rly.rlyspring;

import com.rly.rlyspring.bean.AnnotationApplicationContext;
import com.rly.rlyspring.bean.ApplicationContext;
import com.rly.rlyspring.service.UserService;

public class TestUser {
    static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.rly");

        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);

        userService.add();

    }
}
