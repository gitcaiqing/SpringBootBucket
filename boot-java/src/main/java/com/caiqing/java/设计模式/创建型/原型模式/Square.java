package com.caiqing.java.设计模式.创建型.原型模式;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 15:02
 **/
public class Square implements Shap{
    @Override
    public Object clone() {
        Square square = null;
        try {
        square = (Square) super.clone();
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
        System.out.println("拷贝失败");
    }

        return square;
}

    @Override
    public void countArea() {
        int a=0;
        System.out.print("这是一个正方形，请输入它的边长：");
        Scanner input=new Scanner(System.in);
        a=input.nextInt();
        System.out.println("该正方形的面积="+a*a+"\n");
    }
}

