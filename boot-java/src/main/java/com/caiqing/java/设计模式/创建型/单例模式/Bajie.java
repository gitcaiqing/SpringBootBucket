package com.caiqing.java.设计模式.创建型.单例模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 14:44
 **/
public class Bajie {

    private String name;

    private static Bajie bajie = new Bajie("八戒");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Bajie(String name){
        this.name = name;
    }

    public static Bajie getInstance(){
        return bajie;
    }
}
