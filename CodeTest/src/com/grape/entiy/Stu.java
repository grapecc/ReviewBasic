package com.grape.entiy;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description :
 *
 * @date 2021/8/22 11:01
 */
public class Stu {
    int id;
    String sname;
    int age;

    /**
     * 构造器：又称构造方法
     * 构造器通过 new 调用
     * 构造器虽然有返回值，但不能定义返回类型  不能使用return返回某个值
     * 系统默认无参构造器，如果已经定义了，系统不会自动添加
     * 构造器方法名和类名要一致
     * @param id
     * @param sname
     * @param age
     */
    public Stu(int id, String sname, int age) {
        this.id = id;
        this.sname = sname;
        this.age = age;
    }
//
//    //构造方法
//    public Stu() {
//
//    }


    //方法
    void study(){
        System.out.println("我要学习了！");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Stu stu = new Stu(12,"tom",55);
        System.out.println(stu.id);
        System.out.println(stu.sname);
        System.out.println(stu.age);
        stu.study();
    }
}
