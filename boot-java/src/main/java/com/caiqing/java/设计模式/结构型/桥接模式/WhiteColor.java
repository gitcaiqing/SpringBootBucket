package com.caiqing.java.设计模式.结构型.桥接模式;

/**
 * @Description 扩充实现类
 * @Author CQ
 * @Date 2020/6/29 14:34
 **/
public class WhiteColor implements Color{

    @Override
    public void bepaint(String penType, String name) {
        System.out.println(penType + " 白色的 " + name);
    }
}

