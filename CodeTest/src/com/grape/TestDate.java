package com.grape;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description :
 *
 * @date 2021/8/29 16:35
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
        long now = System.currentTimeMillis(); ///获取当前毫秒数
        System.out.println("当前毫秒数为"+now);


        Date d = new Date(); //无参时为  当前时间
        System.out.println("当前为"+d);
        System.out.println("当前时间为"+d.getTime());

        Date d1 = new Date(1000l*3600*24*365*250);
        System.out.println("当前为："+d1);

        System.out.println("---------------");
        ///DateFormat   SimpleDateFormat
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("s1:"+s1.format(new Date()));
        System.out.println("s2:"+s2.format(new Date()));

        //字符串转化为时间对象
        s1.parse("1997-3-28");
    }
}
