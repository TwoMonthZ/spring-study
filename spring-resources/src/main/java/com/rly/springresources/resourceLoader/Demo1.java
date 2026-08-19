package com.rly.springresources.resourceLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class Demo1 {
    static void main(String[] args) {
        //ClassPathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("a.txt");
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        //File
        ApplicationContext context1 = new FileSystemXmlApplicationContext();
        Resource resource1 = context1.getResource("a.txt");
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

    }
}
