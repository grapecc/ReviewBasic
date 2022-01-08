package com.grape.IODemo;

import java.io.*;

/**
 *转化流  InputStreamReader  OutputStreamWriter  将字节流转化为 字符流
 *
 */
public class LineNumberDemo2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
//           InputStreamReader(转化六) 将字节流 转化为字符流
            br = new BufferedReader(new InputStreamReader( new FileInputStream("D:/Download/a2.txt")));
//         字节输出流转为为字符输出流
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/Download/a3.txt")));
            String temp ="";
            int i = 0;
            while((temp = br.readLine())!= null){
                bw.write(i +','+temp);
                bw.newLine();
                i++;
            }
              bw.flush();
        }catch ( Exception e){
            e.fillInStackTrace();
        }finally {
            try{
                if (br != null){
                    br.close();
                }
                if (bw != null){
                    bw.close();
                }
            }catch (Exception e){
                e.fillInStackTrace();
            }
        }
    }
}
