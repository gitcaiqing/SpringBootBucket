package com.caiqing.java.设计模式.结构型.桥接模式;

/**
 * @Description 给出实现化角色接口的具体实现
 * @Author CQ
 * @Date 2020/6/29 14:33
 **/
public class RedColor implements Color{
    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType + " 红色的 " + name);
    }
}
