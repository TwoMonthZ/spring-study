package com.rly.springaop.xmlaop;

import com.rly.springaop.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TsetAspect {
    static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanaop.xml");

        Calcutor bean = (Calcutor) context.getBean("calcutorImpl2", Calcutor.class);

        bean.add(2,3);
    }
}
