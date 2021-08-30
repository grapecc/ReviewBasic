package com.grape;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 练习 比较string 和stringBuiler性能测试
 *
 * @date 2021/8/29 16:06
 */
public class TestString {

    public static void main(String[] args) {
        //使用String 进行字符串拼接
        String str = "";
        //本质上使用StringBuilder进行拼接，但是每次训话你都会生成一个StringBuilder对象
        long num1 = Runtime.getRuntime().freeMemory();//获取系统剩余空间
        long time1 = System.currentTimeMillis();//获取系统当前时间
        for (int i = 0; i < 5000 ; i++) {
            str += i;
        }
        long num2 = Runtime.getRuntime().freeMemory();//获取系统剩余空间
        long time2 = System.currentTimeMillis();//获取系统当前时间
        System.out.println("使用空间为:"+(num1-num2));
        System.out.println("使用时间为:"+(time2-time1));
        System.out.println("-------------------------");
        StringBuilder sb1 = new StringBuilder("");
        long num3 = Runtime.getRuntime().freeMemory();//获取系统剩余空间
        long time3 = System.currentTimeMillis();//获取系统当前时间
        for (int i = 0; i < 5000 ; i++) {
            sb1.append(i);
        }
        long num4 = Runtime.getRuntime().freeMemory();//获取系统剩余空间
        long time4 = System.currentTimeMillis();//获取系统当前时间
        System.out.println("使用空间为:"+(num3-num4));
        System.out.println("使用时间为:"+(time4-time3));
    }
}
