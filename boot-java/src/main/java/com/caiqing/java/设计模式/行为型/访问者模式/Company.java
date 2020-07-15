package com.caiqing.java.设计模式.行为型.访问者模式;

/**
 * @Description 抽象访问者
 * @Author CQ
 * @Date 2020/7/9 15:21
 **/
public interface Company {

    //创造纸张相关作品
    String create(Paper paper);

    //创造铜相关作品
    String create(Cuprum cuprum);
}
