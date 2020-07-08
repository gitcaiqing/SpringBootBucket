package com.caiqing.java.设计模式.行为型.职责链模式;

/**
 * @Description 案例分析：
 * 假如规定学生请假小于或等于 2 天，班主任可以批准；小于或等于 7 天，系主任可以批准；小于或等于 10 天，院长可以批准；
 * 其他情况不予批准；这个实例适合使用职责链模式实现。
 * @Author CQ
 * @Date 2020/7/7 15:22
 **/
public class Test {

    public static void main(String[] args) {
        Leader classAdvices = new ClassAdviser();

        Leader departmentHead = new DepartmentHead();

        classAdvices.setNext(departmentHead);

        classAdvices.handleRequest(1);

        classAdvices.handleRequest(3);

        classAdvices.handleRequest(4);

        classAdvices.handleRequest(10);
    }

}
