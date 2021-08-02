
package com.company;

import java.io.*;

// 1. 继承ClassLoader
// 2. 覆盖 findClass方法
public class MyFileClassLoader extends ClassLoader {

    private String directory; // 被加载类所在的目录

    public MyFileClassLoader(String directory) { // 默认父类加载器就是系统类加载器 AppClassLoader
        this.directory = directory;
    }

    public MyFileClassLoader(ClassLoader parent, String directory) {
        super(parent);
        this.directory = directory;
    }


}