package com.caiqing.java.设计模式.创建型.原型模式;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 14:59
 **/
public class Circle implements Shap{
    @Override
    public Object clone() {
        Circle circle = null;
        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("拷贝失败");
        }

        return circle;
    }

    @Override
    public void countArea() {
        int r=0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner input=new Scanner(System.in);
        r=input.nextInt();
        System.out.println("该圆的面积="+3.1415*r*r+"\n");
    }
}
