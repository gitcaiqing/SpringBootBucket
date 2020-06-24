package com.caiqing.java.设计模式.创建型.建造者模式;

/**
 * @Description 指挥者：项目经理
 * @Author CQ
 * @Date 2020/6/24 14:20
 **/
public class ProjectManager {

    //维护建造者对象
    private Decorator builder;

    //构建时传入 建造者对象
    public ProjectManager(Decorator builder){
        this.builder = builder;
    }

    //客厅产品构建与组装
    public Keting decorate(){
        builder.buildWall();
        builder.buildTv();
        builder.buildSofa();
        return builder.getResult();
    }
}
