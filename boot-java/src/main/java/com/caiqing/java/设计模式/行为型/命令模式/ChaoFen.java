package com.caiqing.java.设计模式.行为型.命令模式;

/**
 * @Description 具体命令  炒粉
 * @Author CQ
 * @Date 2020/7/7 14:08
 **/
public class ChaoFen implements BreakFast{

    //接收者
    ChaoFenChef chaoFenChef;

    ChaoFen(){
        chaoFenChef = new ChaoFenChef();
    }

    //执行命令的具体操作
    @Override
    public void cooking() {
        chaoFenChef.cooking();
    }
}
