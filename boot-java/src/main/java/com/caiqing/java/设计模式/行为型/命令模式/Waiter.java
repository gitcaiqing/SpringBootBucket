package com.caiqing.java.设计模式.行为型.命令模式;

/**
 * @Description 调用者 服务员
 * @Author CQ
 * @Date 2020/7/7 14:10
 **/
public class Waiter {

    //早餐 抽象命令
    private BreakFast chaoFen;

    public void setBreakFast(BreakFast breakFast) {
        this.chaoFen = breakFast;
    }

    public void choseChaoFen(){
        chaoFen.cooking();
    }
}
