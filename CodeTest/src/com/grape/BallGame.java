package com.grape;

import java.awt.*;
import javax.swing.*;
/**
 * Created with IntelliJ IDEA
 * User : Grape
 * Description :
 *
 * @date 2021/8/21 12:55
 */
public class BallGame extends JFrame{
    public  static  void main(String[] args){
        System.out.println("ceshi");
        BallGame game = new BallGame();
        game.launchFrame();
    }
    //创建窗口
    void launchFrame()  {
        setSize(850,501);
        setLocation(100,100);
        setVisible(true);

        //实现东华，每秒绘制窗口 n次
        while(true){
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    double x = 200;
    double y = 200;
    double degree = 3.14/3 ; // 弧度 180/ 3  角度
//    boolean right = true ;
    //绘制
    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");
    public  void paint(Graphics g){
        System.out.println("绘制被打印");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int) x ,  (int) y,null);
        //碰到上下边界
        if (y>431 || y<40){
            degree = - degree;
        }
        if (x>786 || x<40){
            degree = 3.14 -degree;
        }
        x += 10*Math.cos(degree);
        y += 10*Math.sin(degree);
//        if (right){
//            x += 10;
//        }else{
//            x -= 10;
//        }
//        if (x< 786){
//            right = !right ;
//        }
//        if(x > 40){
//            right = !right ;
//        }
    }
}
