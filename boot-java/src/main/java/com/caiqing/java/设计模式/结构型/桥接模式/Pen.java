package com.caiqing.java.设计模式.结构型.桥接模式;

/**
 * @Description 抽象化角色 定义抽象类，并包含一个对实现化对象的引用。
 * @Author CQ
 * @Date 2020/6/29 14:31
 **/
public abstract class Pen {

    //实现化
    protected Color color;

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void draw(String name);
}
