package com.caiqing.java.java8.lambda;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestLambda {
	public static void main(String[] args) {


		int i=9;
		switch (i) {
			default:
				System.out.println("default");
			case 0:
				System.out.println("zero");
				break;
			case 1:
				System.out.println("one");
				break;
			case 2:
				System.out.println("two");
				break;
		}
	}

	List<Employ> employs = Arrays.asList(
			new Employ(18, 5555.55, "张三"),
			new Employ(22, 6666.66, "李四"),
			new Employ(33, 3333.33, "王五"),
			new Employ(44, 9999.99, "赵六"),
			new Employ(55, 8888.88, "田七"));
	//定义过滤员工返回新员工集合方法
	public List<Employ> getEmployByFilter(List<Employ> employs, EmployStrategy employStrategy){
		List<Employ> newEmploys = new ArrayList<Employ>();
		for(Employ employ : employs) {
			if(employStrategy.filterEmploy(employ)) {
				newEmploys.add(employ);
			}
		}
		return newEmploys;
	}

	//通过策略模式实现
	@Test
	public void test() {
		//根据年龄过滤
		List<Employ> ageFilterEmploys = getEmployByFilter(employs, new com.caiqing.java.java8.lambda.EmployFilterByAge());
		System.out.println("年龄大于25的员工：");
		for (Employ e : ageFilterEmploys) {
			System.out.println(e);
		}

		//根据工资过滤
		List<Employ> salaryFilterEmploys = getEmployByFilter(employs, new com.caiqing.java.java8.lambda.EmployFilterBySalary());
		System.out.println("工资大于6000的员工：");
		for (Employ e : salaryFilterEmploys) {
			System.out.println(e);
		}
	}

	//通过匿名内部类实现
	@Test
	public void test2() {
		//根据年龄过滤
		List<Employ> ageFilterEmploys = getEmployByFilter(employs, new EmployStrategy() {
			@Override
			public boolean filterEmploy(Employ employ) {
				return employ.getAge() > 25 ? true : false;
			}
		});
		System.out.println("年龄大于25的员工：");
		for (Employ e : ageFilterEmploys) {
			System.out.println(e);
		}
		//根据年龄过滤
		List<Employ> salaryFilterEmploys = getEmployByFilter(employs, new EmployStrategy() {
			@Override
			public boolean filterEmploy(Employ employ) {
				return  employ.getSalary() > 6000 ? true : false;
			}
		});
		System.out.println("工资大于6000的员工：");
		for (Employ e : salaryFilterEmploys) {
			System.out.println(e);
		}
	}

	//Lambda表达式实现
	@Test
	public void test3() {
		List<Employ> ageFilterEmploys = getEmployByFilter(employs, e -> e.getAge() > 25);
		System.out.println("年龄大于25的员工：");
		for (Employ e : ageFilterEmploys) {
			System.out.println(e);
		}

		List<Employ> salaryFilterEmploys = getEmployByFilter(employs, e -> e.getSalary() > 6000);
		System.out.println("年龄大于25的员工：");
		for (Employ e : salaryFilterEmploys) {
			System.out.println(e);
		}
	}


	@Test
	public void test4() {
		new Thread(() -> System.out.println("无参无返回值Lambda表达式")).start();
	}



/*
	@Test
	public void test1() {
		Comparable<Integer> com = new Comparable<Integer>() {
			@Override
			public int compareTo(Integer num) {
				return Integer.compare(10, num);
			}
		};
		System.out.println(com.compareTo(20));

		Comparable<Integer> com2 = (x) -> Integer.compare(10, x);
		System.out.println(com2.compareTo(20));


		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("aaaaaaaaaaaaa");
			}
		}).start();

		new Thread(() -> System.out.println());
	}

	@Test
	public void test2() {
		//遍历获取年龄大于30的
		employs.forEach(System.out::println);
	}

	@Test
	public void test3() {
		//遍历获取年龄大于30的
		List<Employ> employs3 = employs.stream()
				.filter(e -> e.getAge()>30)
				.collect(Collectors.toList());
		System.out.println(employs3);
	}


	@Test
	public void test4() {
		//遍历获取年龄大于30的
		List<Employ> employ4 = employs.stream().filter(e -> e.getName().equals("田七")).collect(Collectors.toList());
		employ4.forEach(System.out::println);
	}

	@Test
	public void test5() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstanceStrong();
		System.out.println(secureRandom.nextInt());
	}


	private static final List<Integer> arrayList = Arrays.asList(1, 25, 6, 9, 22, 44);

	private static final int[] intArray = {1, 25, 6, 9, 22, 44};


	//累加
	@Test
	public void test6(){
		int a =  arrayList.stream().reduce(Integer::sum).get();
		System.out.println(a);
	}
	//int数组累加累加
	@Test
	public void test7(){
		int sum =  Arrays.stream(intArray).boxed().reduce(Integer::sum).get();
		System.out.println(sum);
	}
	*/

	@Test
	public void test7(){
		java.util.Map<String, Object> map = new HashMap<>();
		String qydm = String.valueOf(map.get("qydm"));
		System.out.println(qydm);
	}




}
