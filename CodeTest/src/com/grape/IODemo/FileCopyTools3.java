package com.grape.IODemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Eiaml: chengrape@foxmail.com
 * 文件拷贝封装方法
 * @date 2021/11/2 21:35
 */
public class FileCopyTools3 {
    public static void main(String[] args) {
        copyFile("D:/Download/a2.txt","D:/Download/a13.txt");
    }
    public static void copyFile(String src,String des){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new FileReader(src));
            bw = new BufferedWriter(new FileWriter(des));
            String temp = "";
            while ((temp = br.readLine()) != null){
                bw.write(temp);
                bw.newLine();
            }
            bw.flush();
        }catch (Exception e){
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

            }
        }
    }
}
