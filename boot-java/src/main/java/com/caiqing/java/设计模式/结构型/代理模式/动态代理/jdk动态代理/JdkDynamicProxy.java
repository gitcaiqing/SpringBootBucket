package com.caiqing.java.设计模式.结构型.代理模式.动态代理.jdk动态代理;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/28 13:10
 **/
public class JdkDynamicProxy implements InvocationHandler {

    Object targetObject;

    public Object getProxy(Object object){
        this.targetObject = object;
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        Object result = method.invoke(targetObject, args);

        return result;
    }
}
