package com.caiqing.java.设计模式.行为型.迭代器模式;

import java.util.List;
import java.util.Objects;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/8 16:13
 **/
public class ConcreteIterator implements Iterator{

    List<Object> objects = null;

    private int index = -1;

    public ConcreteIterator(List<Object> objects) {
        this.objects = objects;
    }

    @Override
    public Object first() {
        index = 0;
        Object object = objects.get(index);
        return object;
    }

    @Override
    public Object next() {
        Object object = null;
        if(hasNext()){
            object = objects.get(++index);
        }
        return object;
    }

    @Override
    public boolean hasNext() {
        if(index < objects.size() - 1){
            return true;
        }
        return false;
    }
}
