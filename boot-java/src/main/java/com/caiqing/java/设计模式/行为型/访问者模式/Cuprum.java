package com.caiqing.java.设计模式.行为型.访问者模式;

/**
 * @Description 具体元素类：铜
 * @Author CQ
 * @Date 2020/7/9 15:22
 **/
public class Cuprum implements Material{
    @Override
    public String accept(Company visitor) {
        return visitor.create(this);
    }
}
