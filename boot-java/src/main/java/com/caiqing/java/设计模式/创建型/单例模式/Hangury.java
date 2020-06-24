package com.caiqing.java.设计模式.创建型.单例模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 14:46
 **/
public class Hangury {

    public static void main(String[] args) {
        Bajie bajie = Bajie.getInstance();
        System.out.println(bajie.getName());
    }
}
