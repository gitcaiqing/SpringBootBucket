package com.caiqing.java.设计模式.行为型.中介者模式;

/**
 * @Description 具体同事类：仓库
 * @Author CQ
 * @Date 2020/7/8 14:46
 **/
public class Stock extends AbstractColleague{


    //增加库存
    public void increase(String name, int num){
        System.out.println(name+"库存增加"+num);
    }

    //减少库存
    public void decrease(String name, int num){
        System.out.println(name+"库存减少"+num);
    }

}
