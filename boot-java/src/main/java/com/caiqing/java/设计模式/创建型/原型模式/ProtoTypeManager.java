package com.caiqing.java.设计模式.创建型.原型模式;

import java.util.HashMap;

/**
 * @Description 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象
 * @Author CQ
 * @Date 2020/6/23 15:03
 **/
public class ProtoTypeManager {

    private HashMap<String, Shap> hashMap = new HashMap<>();
    public ProtoTypeManager(){
        hashMap.put("Circle", new Circle());
        hashMap.put("Square", new Square());
    }

    public void addShap(String key, Shap shap){
        hashMap.put(key, shap);
    }

    public Shap getShap(String key){
        Shap temp = hashMap.get(key);
        return (Shap)temp.clone();
    }
}
