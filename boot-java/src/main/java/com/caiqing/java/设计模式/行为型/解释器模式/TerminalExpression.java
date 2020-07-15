package com.caiqing.java.设计模式.行为型.解释器模式;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 终结符表达式
 * 是抽象表达式的子类，用来实现文法中与终结符相关的操作，文法中的每一个终结符都有一个具体终结表达式与之相对应。
 * @Author CQ
 * @Date 2020/7/13 16:10
 **/
public class TerminalExpression implements Expression {

    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data){
        for(int i=0; i<data.length; i++){
            set.add(data[i]);
        }
    }

    @Override
    public boolean interpret(String info) {
        if(set.contains(info)){
            return true;
        }
        return false;
    }
}
