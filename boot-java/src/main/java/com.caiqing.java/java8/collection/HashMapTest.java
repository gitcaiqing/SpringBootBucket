package com.caiqing.java.java8.collection;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/16 14:21
 **/
public class HashMapTest {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("a", "value1");
        hashMap.put("b", "value2");
        hashMap.put("c", "value3");
        hashMap.put("a", "value1");
        hashMap.put("b1", "value2");
        System.out.println(hashMap.toString());

    }
}
