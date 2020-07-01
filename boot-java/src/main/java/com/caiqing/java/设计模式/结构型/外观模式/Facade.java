package com.caiqing.java.设计模式.结构型.外观模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/29 16:09
 **/
public class Facade {

    SubSystem1 subSystem1;
    SubSystem2 subSystem2;

    Facade(){
        subSystem1 = new SubSystem1();
        subSystem2 = new SubSystem2();
    }

    public void methodA(){
        subSystem1.mehtodA();
    }

    public void methodB(){
        subSystem2.mehtodB();
    }
}
