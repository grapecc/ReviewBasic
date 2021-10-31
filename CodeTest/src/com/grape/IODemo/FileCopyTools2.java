package com.grape.IODemo;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Eiaml: chengrape@foxmail.com
 *
 * @date 2021/10/31 22:19
 */
public class FileCopyTools2 {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try{
            fr = new FileReader("D:/Download/a2.txt"); // ‰»Î¡˜
            fw = new FileWriter("D:/Download/a3.txt");
            char[] buffer = new char[1024];
            int temp = 0 ;
            while ((temp = fr.read(buffer)) != -1 ){
                fw.write(buffer,0,temp);
            }
            fw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fr != null){
                    fr.close();
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
