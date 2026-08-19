package com.rly.springresources.di;

import com.rly.springresources.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBean {

    static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ResourceBean resourceBean = context.getBean("resourceBean", ResourceBean.class);
        resourceBean.setResource(context.getResource("a.txt"));
        resourceBean.parse();
    }
}
