package com.rly.springiocxml;

import com.rly.springiocxml.dimap.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TsetStu {

    @Test
    public void testStu(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dimap.xml");

        Student student = (Student) context.getBean("student");

        System.out.println(student);
        student.run();
    }
}
