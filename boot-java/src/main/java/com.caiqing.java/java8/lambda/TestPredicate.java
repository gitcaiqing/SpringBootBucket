package com.caiqing.java.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class TestPredicate {
	//从集合中获取部分满足条件的元素放入新集合并返回
	public List<Integer> getList(List<Integer> list, Predicate<Integer> pre){
		List<Integer> listNew = new ArrayList<>();
		for(Integer v : list) {
			if(pre.test(v)) {
				listNew.add(v);
			}
		}
		return listNew;
	}
	@Test
	public void test() {
		List<Integer> list = Arrays.asList(39,8,12,99,22);
		//获取值小于30，并返回新集合
		List<Integer> listNew = getList(list, (value) -> value < 30);
		System.out.println("小于30："+listNew);
		//获取值大于40，并返回新集合
		listNew = getList(list, value -> value > 40);
		System.out.println("大于40："+listNew);
	}
}
