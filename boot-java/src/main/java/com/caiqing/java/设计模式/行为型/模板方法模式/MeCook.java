package com.caiqing.java.设计模式.行为型.模板方法模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/2 16:57
 **/
public class MeCook extends Cook{
    @Override
    void oil() {
        System.out.println("我放1斤油");
    }

    @Override
    void egg() {
        System.out.println("我放1个鸡蛋");
    }

    @Override
    void tomato() {
        System.out.println("我放1个西红柿");
    }

    //子类传递命令
    @Override
    public boolean isAddOil() {
        return false;
    }
}
