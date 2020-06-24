package com.caiqing.java.设计模式.创建型.建造者模式;

/**
 * @Description 需要建造的产品：客厅
 * @Author CQ
 * @Date 2020/6/24 14:08
 **/
public class Keting {

    //客厅包含具体的组成部分 墙 电视 沙发 等...
    private String wall;

    private String tv;

    private String sofa;

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    //对外提供展示客厅方法
    public void show(){
        System.out.println("展示---->"+ "墙:"+wall + " 电视：" +tv + " 沙发:"+sofa);
    }
}
