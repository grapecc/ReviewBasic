package com.grape.IODemo;

import java.io.FileWriter;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Eiaml: chengrape@foxmail.com
 *
 * @date 2021/10/31 21:45
 */
public class FileWritterDemo {
    public static void main(String[] args) {
        FileWriter fw = null;
        FileWriter fw2 = null;
        try{

            fw = new FileWriter("D:/Download/a2.txt");
            fw.write("你好！grape\r\n");
            fw.flush();
            //多个 FileWriter 只会进行覆盖
//            fw2 = new FileWriter("D:/Download/a2.txt");
//            如果想追加的话
            fw2 = new FileWriter("D:/Download/a2.txt",true);
            fw2.write("dwd\r\nasd");
            fw2.flush();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if (fw != null){
                    fw.close();
                }if (fw2 != null){
                    fw2.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
