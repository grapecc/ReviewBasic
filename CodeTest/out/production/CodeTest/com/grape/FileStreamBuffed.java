package com.grape;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 文件输入流和字符输入流操作案例练习
 *
 * @date 2021/8/30 20:57
 */
public class FileStreamBuffed {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null; //字符输入流
        BufferedOutputStream bos = null;
        try{

            fis = new FileInputStream("D:/Download/1.jpg");
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream("D:/Download/2.jpg");
            bos = new BufferedOutputStream(fos);

            int temp = 0;
            while ( (temp = bis.read() ) != -1){
                bos.write(temp);
            }
            bos.flush();




//            int temp = 0;
//            while ( (temp = bis.read()) != -1){
//                bos.write(temp);
//            }
//            bos.flush();

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
