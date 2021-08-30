package com.grape.entiy;

/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description : 构造器方法重载 就是方法名相同  参数不同，个数不同
 *
 * @date 2021/8/22 13:45
 */
class Point{
    double x,y;

    public Point(double x) {
        this.x = x;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point p){
        return  Math.sqrt((x - p.x)*(x - p.x)+(y - p.y)*(y - p.y));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
public class TestConstructor {
    public static void main(String[] args) {
        Point p = new Point(3,4);
        Point origin = new Point(0,0);
       System.out.println(p.getDistance(origin));
    }
}
