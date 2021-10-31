package com.grape.IODemo;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Eiaml: chengrape@foxmail.com
 *
 * @date 2021/10/31 23:05
 */
public class BufferWriterDemo {
    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter("D:/Download/a4.txt");
            bw = new BufferedWriter(fw);
            bw.write("你好测试！");
            bw.write("test");
            bw.newLine();
            bw.write("shishsihs");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (bw != null){
                    bw.close();
                }
                if (fw != null){
                    fw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
