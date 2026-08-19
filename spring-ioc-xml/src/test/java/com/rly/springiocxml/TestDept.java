package com.rly.springiocxml;

import com.rly.springiocxml.ditest.Dept;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDept {
    static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");

        Dept dept = (Dept) context.getBean("dept");

        System.out.println(dept);
        dept.info();
    }
}
