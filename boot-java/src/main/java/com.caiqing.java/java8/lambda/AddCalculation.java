package com.caiqing.java.java8.lambda;

//定义加法法运算 实现公共接口
public class AddCalculation implements Calculation {

	@Override
	public Integer method(Integer a, Integer b) {
		return a + b;
	}

}
