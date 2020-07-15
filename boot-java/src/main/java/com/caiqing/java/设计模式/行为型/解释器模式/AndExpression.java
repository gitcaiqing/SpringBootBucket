package com.caiqing.java.设计模式.行为型.解释器模式;

/**
 * @Description 非终结符表达式
 * @Author CQ
 * @Date 2020/7/13 16:11
 **/
public class AndExpression implements Expression{

    private Expression city = null;

    private Expression person = null;

    AndExpression(Expression city, Expression person){
        this.city = city;
        this.person = person;
    }


    @Override
    public boolean interpret(String info) {
        String[] s = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}
