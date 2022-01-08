package com.grape.IODemo;

import java.io.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LineNumberDemo3.java
 * @Description TODO
 * @createTime 2021年11月10日 22:55:00
 * 字符出书流 printWriter 节点流非处理流
 */
public class LineNumberDemo3 {
    public static void main(String[] args) {
        BufferedReader br = null; //缓冲流
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/Download/a2.txt")));
            pw = new PrintWriter("D:/Download/a5.txt");
            String temp = "";
            int i = 0;
            while ((temp = br.readLine()) != null){
                pw.println(i +','+temp);
                i++;
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            try{
                if (br != null){
                    br.close();
                }
                if (pw != null){
                    pw.close();
                }
            }catch (Exception e){
                e.fillInStackTrace();
            }
        }
    }
}
