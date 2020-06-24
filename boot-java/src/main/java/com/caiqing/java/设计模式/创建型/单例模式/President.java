package com.caiqing.java.设计模式.创建型.单例模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 14:31
 **/
public class President {



    private String name;

    private static President instance = null;

    private President(){
        System.out.println("产生一个总统");
    }

    private President(String name){
        this.name = name;
        System.out.println("产生一个总统："+name);
    }

    public static synchronized President getInstance(String name){
        if(instance == null){
            instance = new President(name);
        }else{
            System.out.println("已经有总统了，不能产生新的了");
        }
        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getName(){
        System.out.println("我是总统: "+ this.name);
    }
}
