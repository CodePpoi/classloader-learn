package com.company;

import sun.net.spi.nameservice.dns.DNSNameService;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    public static void main(String[] args) throws Exception {
        // BootStrap加载器，C++编写，加载<JAVA_HOME>\jre\lib里面的类库(比如rt.jar，rt是runtime的简称)
        ClassLoader classLoader = Object.class.getClassLoader();
        System.out.println(classLoader); // 打印null

        classLoader = Number.class.getClassLoader();
        System.out.println(classLoader); // 打印null

        //Extension加载器，纯java编写，ExtClassLoader，加载<JAVA_HOME>\jre\lib\ext里面的类库(比如dnsns.jar)或者系统变量"java.ext.dirs"指定目录下面的类
        ClassLoader classLoader1 = DNSNameService.class.getClassLoader();
        System.out.println(classLoader1);


        //System加载器，纯java编写，AppclassLoader，我们写的java程序一般由这个加载
        ClassLoader classLoader2 = Main.class.getClassLoader();
        System.out.println(classLoader2);

        MyFileClassLoader classLoader3 = new MyFileClassLoader("");
        Class<?> clazz = classLoader3.loadClass("com.company.Demo");
        clazz.newInstance();
        //自己定义的类，默认继承AppClassLoader
        System.out.println(clazz.getClassLoader());

//        File file = new File("d:/");
//        URI uri = file.toURI();
//        URL url = uri.toURL();
//
//        URLClassLoader classLoader3 = new URLClassLoader()

    }
}
