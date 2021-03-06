package com.caiqing.java.设计模式.结构型.享元模式;

/**
 * @Description 享元（Flyweight）模式的定义：运用共享技术来有効地支持大量细粒度对象的复用。
 * 它通过共享已经存在的对象来大幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源的
 *
 * 享元模式中存在以下两种状态：
 * 内部状态，即不会随着环境的改变而改变的可共享部分；
 * 外部状态，指随环境改变而改变的不可以共享的部分。享元模式的实现要领就是区分应用中的这两种状态，并将外部状态外部化。下面来分析其基本结构和实现方法。
 *
 * 享元模式的主要角色有如下。
 * 抽象享元角色（Flyweight）:是所有的具体享元类的基类，为具体享元规范需要实现的公共接口，非享元的外部状态以参数的形式通过方法传入。
 * 具体享元（Concrete Flyweight）角色：实现抽象享元角色中所规定的接口。
 * 非享元（Unsharable Flyweight)角色：是不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中。
 * 享元工厂（Flyweight Factory）角色：负责创建和管理享元角色。当客户对象请求一个享元对象时，享元工厂检査系统中是否存在符合要求的享元对象，
 * 如果存在则提供给客户；如果不存在的话，则创建一个新的享元对象。
 *
 * @Author CQ
 * @Date 2020/6/29 16:31
 **/
public class Test {

    public static void main(String[] args) {
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        Flyweight flyweight0  = flyWeightFactory.getFlyWeight("a");
        Flyweight flyweight1 = flyWeightFactory.getFlyWeight("b");
        Flyweight flyweight2 = flyWeightFactory.getFlyWeight("a");
        Flyweight flyweight3 = flyWeightFactory.getFlyWeight("b");

        flyweight0.operation(new UnSharedConcreteFlyweight("第1次调用a"));
        flyweight1.operation(new UnSharedConcreteFlyweight("第1次调用b"));
        flyweight2.operation(new UnSharedConcreteFlyweight("第2次调用a"));
        flyweight3.operation(new UnSharedConcreteFlyweight("第2次调用b"));

    }
}
