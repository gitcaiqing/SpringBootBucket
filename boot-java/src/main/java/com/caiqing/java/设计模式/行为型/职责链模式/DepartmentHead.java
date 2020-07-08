package com.caiqing.java.设计模式.行为型.职责链模式;

/**
 * @Description 系主任
 * @Author CQ
 * @Date 2020/7/7 15:47
 **/
public class DepartmentHead extends Leader{
    @Override
    public void handleRequest(int days) {
        if(days <= 5){
            System.out.println("系主任批假"+days+"天");
        }else{
            if(getNext() != null){
                getNext().handleRequest(days);
            }else{
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
