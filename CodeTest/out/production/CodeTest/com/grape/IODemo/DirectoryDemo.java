package com.grape.IODemo;

import java.io.File;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 文件目录
 *
 * @date 2021/8/31 21:04
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        File file  = new File("D:/Download/a");
        boolean mkdir = file.mkdir();//创建单级文件目录
//        File file  = new File("D:/Download/a/b/d");
//        file.mkdirs();//创建多级目录
        System.out.println(mkdir);//
        System.out.println(file.getPath());
        System.out.println(file.isFile());//判断是否为文件
        System.out.println(file.isDirectory());//判断是否为目录
        System.out.println(file.getParent());//获取字符串
        System.out.println(file.getParentFile().getName());//获取的对象



        File file2 =  new File("D:/");
        String[] list = file2.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------");
        File[] files = file2.listFiles(); ///获取文件和路径
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
