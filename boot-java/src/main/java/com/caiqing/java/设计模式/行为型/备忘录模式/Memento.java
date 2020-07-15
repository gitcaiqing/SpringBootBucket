package com.caiqing.java.设计模式.行为型.备忘录模式;

/**
 * @Description 备忘录
 * 负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * @Author CQ
 * @Date 2020/7/13 15:05
 **/
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
