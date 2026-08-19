package com.rly.springaop.annoaop;

import com.rly.springaop.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TsetAspect {
    static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Calcutor bean = (Calcutor) context.getBean("calcutorImpl1", Calcutor.class);

        bean.add(2,3);
    }
}
