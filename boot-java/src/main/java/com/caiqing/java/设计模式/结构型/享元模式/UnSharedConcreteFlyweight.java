package com.caiqing.java.设计模式.结构型.享元模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/29 16:37
 **/
public class UnSharedConcreteFlyweight {

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    UnSharedConcreteFlyweight(String info){
        this.info = info;
    }

}
