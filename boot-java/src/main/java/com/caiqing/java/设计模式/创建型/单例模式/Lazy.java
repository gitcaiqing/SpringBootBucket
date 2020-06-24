package com.caiqing.java.设计模式.创建型.单例模式;

/**
 * @Description 懒汉式单例模式
 * @Author CQ
 * @Date 2020/6/23 14:27
 **/
public class Lazy {

    public static void main(String[] args) {
        /*President president1 = President.getInstance("特朗普1");
        president1.getName();

        President president2 = President.getInstance("特朗普2");
        president2.getName();*/

        new Thread(()->{
            President president3 = President.getInstance("特朗普3");
            president3.getName();
        }).start();

        new Thread(()->{
            President president4 = President.getInstance("特朗普4");
            president4.getName();
        }).start();

        new Thread(()->{
            President president4 = President.getInstance("特朗普5");
            president4.getName();
        }).start();

        new Thread(()->{
            President president4 = President.getInstance("特朗普6");
            president4.getName();
        }).start();
    }




}
