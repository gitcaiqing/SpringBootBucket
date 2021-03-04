package com.caiqing.java.设计模式.结构型.享元模式;

import java.util.HashMap;

/**
 * @Description 享元工厂
 * @Author CQ
 * @Date 2020/6/29 16:49
 **/
public class FlyWeightFactory {

    private HashMap flyweights = new HashMap<String, Flyweight>();

    public Flyweight getFlyWeight(String key){
        Flyweight flyweight = (Flyweight)flyweights.get(key);
        if(flyweight != null){
            System.out.println("具体享元"+key+"已存在， 成功获取");
            return flyweight;
        }
        flyweight = new ConcreteFlyWeight(key);
        flyweights.put(key, flyweight);
        return flyweight;
    }

}
