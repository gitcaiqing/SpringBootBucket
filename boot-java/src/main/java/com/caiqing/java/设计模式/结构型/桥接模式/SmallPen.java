package com.caiqing.java.设计模式.结构型.桥接模式;

/**
 * @Description 是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * @Author CQ
 * @Date 2020/6/29 14:32
 **/
public class SmallPen extends Pen{

    @Override
    public void draw(String name){
        String penType = "小号笔";
        this.color.bepaint(penType, name);
    }
}
