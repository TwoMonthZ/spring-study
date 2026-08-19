package com.rly.rlyspring.bean;

import com.rly.rlyspring.annotation.Bean;
import com.rly.rlyspring.annotation.Di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext{

    //创建map集合，放bean对象
    private Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //创建有参构造，设置包扫描规则，传递包路径
    //当前包及子包
    public AnnotationApplicationContext(String basePackage) {
        try {
            //com.rly
            //1 把.替换为\
            String packagePath = basePackage.replace(".", "\\");
            //2 获取包绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                //获取包前面的路径，字符串截取
                rootPath = filePath.substring(0,filePath.length()-packagePath.length());
                //包扫描
                loadBean(new File(filePath));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //属性注入
        loadDi();
    }
    //属性注入
    private void loadDi() {
        // 实例化对象在beanFactory的map集合里
        //1 遍历map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entries) {
            //2 获取map中每个对象value，每个对象属性获取
            Object obj = entry.getValue();
            //获取对象class
            Class<?> clazz = obj.getClass();
            //获取每个对象属性
            Field[] declaredFields = clazz.getDeclaredFields();
            //3 遍历每个对象属性数组，得到每个属性
            for (Field field : declaredFields) {
                //4 判断属性上是否有@Di注解
                Di di = field.getAnnotation(Di.class);
                if (di != null){
                    //如果私有属性
                    field.setAccessible(true);
                    //5 如果有@Di注解，把对象进行设置（注入）
                    try {
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }


    }

    //包扫描过程，实例化
    private void loadBean(File file) throws Exception {
        //1判断是否为文件夹
        if (file.isDirectory()){
            //2获取文件夹中所有内容
            File[] childFiles = file.listFiles();
            //3判断文件夹文件夹是否为空，直接返回
            if (childFiles == null || childFiles.length == 0){
                return;
            }
            //4如果文件夹不为空，遍历文件夹所有内容
            for (File childFile : childFiles) {
                //4.1遍历得到每个file对象，判断，还是文件夹继续递归
                if (childFile.isDirectory()){
                    loadBean(childFile);
                }else {
                    //4.2如果是文件
                    //4.3得到包路径+类名称-截取
                    String pathWithClass = childFile.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4判断当前文件类型是否为.class
                    if (pathWithClass.contains(".class")){
                        //4.5如果是class，把路径\替换为. 把.class去掉
                        String allName = pathWithClass.replaceAll("\\\\", "\\.").replace(".class", "");
                        //4.6判断类上是否有@Bean，有使用反射进行实例化
                        //4.6.1获取类的class对象
                        Class<?> clazz = Class.forName(allName);
                        //4.6.2判断不是接口，进行实例化
                        if (!clazz.isInterface()){
                            //4.6.3判断是否有注解@Bean
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation !=null ){
                                //4.6.4使用反射进行实例化
                                Object instance = clazz.getConstructor().newInstance();
                                //4.7实例化之后放入map集合中
                                //4.7.1 判断当前类如果有接口，让接口class作为map的key
                                if (clazz.getInterfaces().length>0){
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                }else {
                                    beanFactory.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
