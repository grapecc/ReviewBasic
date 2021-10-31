package com.grape;

import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description :  枚举  一个类有多个实例
 * 例如word文档的对齐方式有几种：左对齐、居中对齐、右对齐。开车的方向有几种：前、后、左、右！
 *
 * @date 2021/8/30 20:06
 */
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Season.spring);

        for (week k: week.values()) {//遍历枚举型
            System.out.println(k);
        }
//        Season[] se =  Season.values();
        int a = new Random().nextInt(4); //0 1 2 3
        switch (Season.values()[a]){
            case spring:
                System.out.println("春天");
                break;
            case summer:
                System.out.println("夏天");
                break;
            case autumn:
                System.out.println("秋天");
                break;
            case winter:
                System.out.println("冬天");
                break;
        }
    }
}
enum Season{
    spring,summer,autumn,winter
}

enum week{
    星期一,星期二,星期三,星期四,星期五,星期六,星期日
}
