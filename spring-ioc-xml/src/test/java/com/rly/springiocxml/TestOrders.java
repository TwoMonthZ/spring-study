package com.rly.springiocxml;

import com.rly.springiocxml.scope.Orders;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {
    static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");

        Orders o = (Orders) context.getBean("orders");

        System.out.println(o);

        Orders o2 = (Orders) context.getBean("orders");

        System.out.println(o2);
    }
}
