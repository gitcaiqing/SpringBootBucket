package com.caiqing.java.设计模式.行为型.访问者模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description 元素对象角色构建
 * @Author CQ
 * @Date 2020/7/9 15:26
 **/
public class SetMaterial {

    List<Material> materials = new ArrayList<>();
    String tmp = "";
    public String accept(Company visitor){
        tmp = "";
        Iterator<Material> it = materials.iterator();
        while (it.hasNext()){
            tmp+= it.next().accept(visitor) + " ";
        }
        return tmp;
    }

    public void add(Material material){
        materials.add(material);
    }

    public void remove(Material material){
        materials.remove(material);
    }
}
