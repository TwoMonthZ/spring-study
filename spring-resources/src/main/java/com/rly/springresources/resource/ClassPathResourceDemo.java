package com.rly.springresources.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

//访问类路径下的资源
public class ClassPathResourceDemo {
    public static void loadClassPathResource(String path) {
        //创建对象
        ClassPathResource classPathResource = new ClassPathResource(path);

        System.out.println(classPathResource.getFilename());
        System.out.println(classPathResource.getDescription());
        try {
            InputStream inputStream = classPathResource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void main(String[] args) {
        loadClassPathResource("a.txt");
    }
}
