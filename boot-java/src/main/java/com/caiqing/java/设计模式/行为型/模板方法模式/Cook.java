package com.caiqing.java.设计模式.行为型.模板方法模式;

/**
 * @Description 定义一个模板方法抽象类
 * @Author CQ
 * @Date 2020/7/2 16:53
 **/
public abstract class Cook {

    //定义模板方法
    //放油
    abstract void oil();

    abstract void egg();

    abstract void tomato();

    final public void cook(){
        if(isAddOil()){
            this.oil();
        }
        this.egg();
        this.tomato();
    }

    //加钩子方法 由子类决定方法的执行顺序
    public boolean isAddOil(){
        return true;
    }
}
