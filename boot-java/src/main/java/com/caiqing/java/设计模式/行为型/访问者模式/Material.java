package com.caiqing.java.设计模式.行为型.访问者模式;

/**
 * @Description 抽象元素类：材料
 * @Author CQ
 * @Date 2020/7/9 15:21
 **/
public interface Material {

    //访问这访问具体元素
    String accept(Company company);
}
