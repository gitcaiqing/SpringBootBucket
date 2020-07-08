package com.caiqing.java.设计模式.行为型.中介者模式;

/**
 * @Description 具体同事类：销售部门
 * @Author CQ
 * @Date 2020/7/8 14:47
 **/
public class Sale extends AbstractColleague{

    //销售
    public void sale(String name, int number){
        super.mediator.execute("sale", name, number);
    }

    //打折销售

    //反馈销售情况 值越大越畅销

}
