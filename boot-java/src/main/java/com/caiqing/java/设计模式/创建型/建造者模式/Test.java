package com.caiqing.java.设计模式.创建型.建造者模式;

/**
 * @Description 建造者模式：指将一个复杂的对象的构造与它的表示分离，使同样的构造过程可以创建不同的表示，
 * 它将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成，即产品的组成部分不变，但每一部分可以灵活选择
 * @Author CQ
 * @Date 2020/6/24 13:52
 **/
public class Test {

    /**
     * 案例：用建造者（Builder）模式描述客厅装修
     * 分析：客厅装修是一个复杂的过程，它包含墙体的装修、电视机的选择、沙发的购买与布局等。客户把装修要求告诉项目经理，
     * 项目经理指挥装修工人一步步装修，最后完成整个客厅的装修与布局，所以本实例用建造者模式实现比较适合。
     *
     * 这里客厅是产品，包括墙、电视和沙发等组成部分。具体装修工人是具体建造者，他们负责装修与墙、电视和沙发的布局。项目经理是指挥者，
     * 他负责指挥装修工人进行装修。
     * @param args
     * @return void
     * @author CQ
     * @date 2020/6/24 14:06
     */
    public static void main(String[] args) {
        ProjectManager projectManager = new ProjectManager(new JutiDecorator());
        Keting keting = projectManager.decorate();
        keting.show();


        projectManager = new ProjectManager(new JutiDecorator2());
        keting = projectManager.decorate();
        keting.show();
    }
}
