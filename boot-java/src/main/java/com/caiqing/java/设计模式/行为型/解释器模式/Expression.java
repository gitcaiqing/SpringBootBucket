package com.caiqing.java.设计模式.行为型.解释器模式;

/**
 * @Description 抽象表达式
 * 定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
 * @Author CQ
 * @Date 2020/7/13 16:09
 **/
public interface Expression {

    boolean interpret(String info);
}
