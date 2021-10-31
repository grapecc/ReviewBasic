package com.grape.IODemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description :  测试案例 第一个io流入门案例
 *
 * @date 2021/8/31 18:59
 */
public class FirstDemo {
    public static void main(String[] args) {
        //创建输入流对象
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("D:/Download/a.txt");
            int s1 = fis.read();///当前读的为第一个字符的ascii码
            int s2 = fis.read();//依次读
            int s3 = fis.read();
            int s4 = fis.read();//文件已读完则会返会-1
            System.out.println("输出打印"+s2);
        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (fis != null){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
