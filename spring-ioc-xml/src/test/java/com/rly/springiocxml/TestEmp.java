package com.rly.springiocxml;

import com.rly.springiocxml.ditest.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
    static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diarray.xml");

        Emp emp = (Emp) context.getBean("emp");

        System.out.println(emp);
        emp.work();
    }
}
