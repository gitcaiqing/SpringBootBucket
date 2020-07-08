package com.caiqing.java.设计模式.行为型.策略模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/6 14:35
 **/
public class EmployFilterBySalary implements EmployStrategy{
    @Override
    public boolean filterEmploy(Employ employ) {
        return employ.getSalary() > 20;
    }
}
