package com.grape;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 文件类 的基本使用方法
 *
 * @date 2021/8/29 17:09
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        File s = new File("a.text");
        s.createNewFile();//创建文件


        File c2 = new File("d:/b.text");
        c2.createNewFile();//创建文件
    }
}
