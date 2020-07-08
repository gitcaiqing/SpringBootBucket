package com.caiqing.java.设计模式.行为型.职责链模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/7 15:42
 **/
public abstract class Leader {

    private Leader next;

    public void setNext(Leader next) {
        this.next = next;
    }

    public Leader getNext() {
        return next;
    }

    public abstract void handleRequest(int days);
}
