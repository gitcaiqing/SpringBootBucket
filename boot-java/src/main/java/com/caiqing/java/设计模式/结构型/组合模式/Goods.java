package com.caiqing.java.设计模式.结构型.组合模式;

/**
 * @Description 树叶构件：商品
 * 是组合中的叶节点对象，它没有子节点，用于实现抽象构件角色中 声明的公共接口。
 * @Author CQ
 * @Date 2020/7/2 10:25
 **/
public class Goods implements Articles{

    //名称
    private String name;

    //数量
    private Long quantity;

    //价格
    private Long price;

    public Goods(String name, Long quantiey, Long price) {
        this.name = name;
        this.quantity = quantiey;
        this.price = price;
    }

    @Override
    public Long calculation() {
        return quantity * price;
    }

    @Override
    public void show() {
        System.out.println("商品："+name+" 数量："+quantity+" 单价"+price);
    }
}
