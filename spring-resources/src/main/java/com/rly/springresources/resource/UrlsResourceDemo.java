package com.rly.springresources.resource;

import org.springframework.core.io.UrlResource;

//演示访问网络资源
public class UrlsResourceDemo
{
    static void main(String[] args) {
        //http
        loadUrlResource("http://www.baidu.com");

        //file
        loadUrlResource("file:a.txt");
    }
    //访问前缀为http资源
    public static void loadUrlResource(String path)
    {
        //创建Resource接口实现类的对象
        try {
            UrlResource urlResource = new UrlResource(path);
            //获取资源信息
            System.out.println(urlResource.getFilename());
            System.out.println(urlResource.getURI());
            System.out.println(urlResource.getDescription());
            System.out.println(urlResource.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
