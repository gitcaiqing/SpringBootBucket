package com.caiqing.java.设计模式.创建型.原型模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 15:05
 **/
public class ProtoTypeShap {
    public static void main(String[] args) {
        ProtoTypeManager protoTypeManager = new ProtoTypeManager();
        Shap circle = protoTypeManager.getShap("Circle");
        circle.countArea();
        Shap square = protoTypeManager.getShap("Square");
        square.countArea();
    }
}
