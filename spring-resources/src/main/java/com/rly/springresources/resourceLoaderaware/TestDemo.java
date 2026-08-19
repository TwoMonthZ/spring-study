package com.rly.springresources.resourceLoaderaware;

import com.rly.springresources.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class TestDemo {
    static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean testBean = context.getBean("testBean", TestBean.class);

        ResourceLoader resourceLoader = testBean.getResourceLoader();

        System.out.println(context == resourceLoader);
    }
}
