package com.caiqing.java.设计模式.结构型.代理模式.动态代理.cglib代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/28 13:25
 **/
public class CglibDynamicProxy implements MethodInterceptor {

    // 被代理对象
    Object targetObject;

    public Object getProxy(Object object){
        this.targetObject = object;
        //增强器
        Enhancer enhancer = new Enhancer();
        //回调方法
        enhancer.setCallback(this);
        //设置生成类的父类类型
        enhancer.setSuperclass(targetObject.getClass());
        return enhancer.create();

    }

    // 拦截方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object result = methodProxy.invoke(targetObject, objects);

        return result;
    }
}
