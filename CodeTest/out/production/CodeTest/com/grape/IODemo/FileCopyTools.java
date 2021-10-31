package com.grape.IODemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 文件拷贝工具
 *
 * @date 2021/9/5 22:02
 */
public class FileCopyTools {
    public static void main(String[] args) {
        copyFile("D:/Download/1.jpg","D:/Download/2.jpg");
    }
    /**
     * 文件拷贝方法
     */
    public  static void copyFile(String src ,String des){
        {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            BufferedInputStream bis = null; //字符输入流
            BufferedOutputStream bos = null;
            try{

                bis = new BufferedInputStream(new FileInputStream(src));
                bos = new BufferedOutputStream(new FileOutputStream(des));

                //创建一个缓冲区
                byte[] buff = new byte[1024]; //一般是2的几次幂
                int temp = 0;
                while ( (temp = bis.read(buff) ) != -1){
                    bos.write(buff,0,temp);//
                }
                bos.flush();


            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try {
                    //关闭流后开 先闭
                    if (bis != null){
                        bis.close();
                    }
                    if (fis != null){
                        fis.close();
                    }
                    if (bos != null){
                        bos.close();
                    }
                    if (fos != null){
                        fos.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
