package com.grape.IODemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Eiaml: chengrape@foxmail.com
 * 利用字符缓冲流实现添加行号
 * @date 2021/11/2 21:58
 */
public class LineNumberDemo {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new FileReader("D:/Download/a2.txt"));
            bw = new BufferedWriter(new FileWriter("D:/Download/a23.txt"));
            String temp = "";
            int i = 1;
            while ((temp = br.readLine()) != null){
                bw.write(i+","+temp);
                bw.newLine();
                i++;
            }
            bw.flush();

        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            try{
                if (br != null){
                    br.close();
                }
                if (bw != null){
                    bw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
