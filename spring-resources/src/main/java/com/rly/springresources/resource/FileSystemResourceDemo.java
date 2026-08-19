package com.rly.springresources.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

//访问系统中资源
public class FileSystemResourceDemo {

    static void main(String[] args) {

        //绝对路径
        loadFileResource("D:\\demo\\spring6-demo\\a.txt");
        //相对路径
        loadFileResource("a.txt");
    }

    public static void loadFileResource(String path) {
        //创建对象
        FileSystemResource fileSystemResource = new FileSystemResource(path);

        System.out.println(fileSystemResource.getFilename());
        System.out.println(fileSystemResource.getDescription());
        try {
            InputStream inputStream = fileSystemResource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b) != -1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
