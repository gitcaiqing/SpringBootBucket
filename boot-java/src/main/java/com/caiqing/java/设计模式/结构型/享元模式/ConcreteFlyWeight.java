package com.caiqing.java.设计模式.结构型.享元模式;

/**
 * @Description 具体享元类， 方法中传入非享元对象
 * @Author CQ
 * @Date 2020/6/29 16:36
 **/
public class ConcreteFlyWeight implements Flyweight {

    private String key;

    ConcreteFlyWeight(String key){
        this.key = key;
        System.out.println("具体享元"+key+"被创建");
    }

    @Override
    public void operation(UnSharedConcreteFlyweight unSharedConcreteFlyweight) {
        System.out.println("非享元信息："+unSharedConcreteFlyweight.getInfo());
    }
}
