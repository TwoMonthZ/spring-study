package com.rly.springiocxml;

import com.rly.springiocxml.dimap.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLesson {
    @Test
    void testLesson(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diref.xml");

        Student bean = (Student) context.getBean("studentp");

        bean.run();
    }
}
