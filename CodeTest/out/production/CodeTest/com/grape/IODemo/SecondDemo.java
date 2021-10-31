package com.grape.IODemo;

import java.io.FileInputStream;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 优化第一入门案例
 *
 * @date 2021/8/31 19:19
 */
public class SecondDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:/Download/a.txt");
            int temp = 0;
            StringBuffer sub = new StringBuffer();
            while ((temp = fis.read()) != -1 ){
                System.out.println(temp);
                sub.append((char)temp);///将acc码进行强转
            }
            System.out.println(sub.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (fis != null ){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
