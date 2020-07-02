package com.caiqing.java.设计模式.结构型.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 树枝构件：袋子
 * 是组合中的分支节点对象，它有子节点。它实现了抽象构件角色中声明的接口，它的主要作用是存储和管理子部件，
 * 通常包含 Add()、Remove()、GetChild() 等方法。
 * @Author CQ
 * @Date 2020/7/2 10:42
 **/
public class Bags implements Articles{

    //名称
    private String name;

    //管理子部件
    private List<Articles> bags = new ArrayList<>();

    public Bags(String name) {
        this.name = name;
    }

    public void add(Articles articles){
        bags.add(articles);
    }

    public void remove(Articles articles){
        bags.remove(articles);
    }

    public Articles getChild(int i){
        return bags.get(i);
    }

    @Override
    public Long calculation() {
        return bags.stream().mapToLong(Articles::calculation).sum();
    }

    @Override
    public void show() {
        bags.forEach(articles -> articles.show());
    }
}
