package com.caiqing.java.设计模式.行为型.备忘录模式;

import com.caiqing.java.设计模式.行为型.模板方法模式.MeCook;

/**
 * @Description 发起人
 * 记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，它可以访问备忘录里的所有信息。
 * @Author CQ
 * @Date 2020/7/13 15:05
 **/
public class Originator {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    //创建备忘录
    public Memento createMemento(){
        return new Memento(state);
    }

    //恢复备忘录
    public void restoreMemento(Memento m){
        this.setState(m.getState());
    }
}
