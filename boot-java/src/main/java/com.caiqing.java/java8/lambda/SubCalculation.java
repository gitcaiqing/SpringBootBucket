package com.caiqing.java.java8.lambda;

//定义减法运算 实现公共接口
public class SubCalculation implements Calculation {

	@Override
	public Integer method(Integer a, Integer b) {
		return a - b;
	}

}
