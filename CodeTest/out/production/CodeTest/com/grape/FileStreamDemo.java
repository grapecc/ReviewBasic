package com.grape;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 优化方法新增一个缓冲区按包进行输出，比原来一个一个输出快
 *
 * @date 2021/9/5 15:03
 */
public class FileStreamDemo {
    public static void main(String[] args){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null; //字符输入流
        BufferedOutputStream bos = null;
        try{

            fis = new FileInputStream("D:/Download/1.jpg");
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream("D:/Download/2.jpg");
            bos = new BufferedOutputStream(fos);

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
