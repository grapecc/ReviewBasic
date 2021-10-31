package com.grape.IODemo;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Eiaml: chengrape@foxmail.com
 * 针对字符流增加 BufferReader和BufferWitter 增加缓冲机制
 * @date 2021/10/31 22:43
 */
public class BufferReaderDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader("D:/Download/a2.txt");
            br = new BufferedReader(fr);
            String temp = "";
            while ((temp = br.readLine()) != null){
                System.out.println(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (br != null){
                    br.close();
                }
                if (fr != null){
                    fr.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
