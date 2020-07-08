package com.caiqing.java.设计模式.行为型.中介者模式;

/**
 * @Description 具体同事类：采购部门
 * @Author CQ
 * @Date 2020/7/8 14:46
 **/
public class Purchase extends AbstractColleague{

    //采购
    public void buy(String name, int number){
        super.mediator.execute("purchase", name, number);
    }

}
