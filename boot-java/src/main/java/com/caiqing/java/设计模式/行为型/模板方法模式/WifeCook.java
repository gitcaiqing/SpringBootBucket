package com.caiqing.java.设计模式.行为型.模板方法模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/2 16:58
 **/
public class WifeCook extends Cook {
    @Override
    void oil() {
        System.out.println("老婆放适量油");
    }

    @Override
    void egg() {
        System.out.println("老婆放适量鸡蛋");
    }

    @Override
    void tomato() {
        System.out.println("老婆放适量西红柿");
    }
}
