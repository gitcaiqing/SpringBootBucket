package com.caiqing.java.设计模式.行为型.策略模式;

/**
 * @Description 具体策略
 * @Author CQ
 * @Date 2020/7/6 14:35
 **/
public class EmployFilterByAge implements EmployStrategy{
    @Override
    public boolean filterEmploy(Employ employ) {
        return employ.getAge() > 20;
    }
}
