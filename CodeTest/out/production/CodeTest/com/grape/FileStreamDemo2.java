package com.grape;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description :在原来的基础上进行再次优化
 *
 * @date 2021/9/5 15:15
 */
public class FileStreamDemo2 {
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
            byte[] buff = new byte[fis.available()]; //直接一次性扛麻袋
            bis.read(buff);
            bos.write(buff);
//            int temp = 0;
//            while ( (temp = bis.read(buff) ) != -1){
//                bos.write(buff,0,temp);//
//            }
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
