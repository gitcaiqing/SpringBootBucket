package com.caiqing.java.设计模式.行为型.解释器模式;

/**
 * @Description 环境类
 *
 * @Author CQ
 * @Date 2020/7/13 16:32
 **/
public class Context {

    private String[] cities = {"韶关", "广州"};

    private String[] persons = {"老人", "妇女", "儿童"};

    private Expression cityPerson;

    public Context(){
        Expression city = new TerminalExpression(cities);

        Expression person = new TerminalExpression(persons);

        cityPerson = new AndExpression(city, person);
    }

    public void freeRide(String info){
        boolean ok = cityPerson.interpret(info);
        if(ok){
            System.out.println("您是："+info+"，免费");
        }else{
            System.out.println("您是："+info+"，缴费2元");
        }
    }
}
