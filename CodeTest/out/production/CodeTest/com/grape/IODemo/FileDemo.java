package com.grape.IODemo;


import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 文件操作demo
 *
 * @date 2021/8/31 19:31
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        //创建file对象
        File file =new File("D:/Download/a2.txt");//
        boolean flag = file.createNewFile();
        if (!flag){
            System.out.println("创建文件失败");
//            return;
        }
        System.out.println(flag);
//        System.out.println("文件是否存在:"+file.delete());
//        System.out.println("文件是否存在:"+file.exists());
        System.out.println("文件名称:"+file.getName());
        System.out.println("是否是文件:"+file.isFile());//判断是否为文件
        System.out.println("文件隐藏:"+file.isHidden());
    }
}
