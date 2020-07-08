package com.caiqing.java.设计模式.行为型.职责链模式;

/**
 * @Description 班主任
 * @Author CQ
 * @Date 2020/7/7 15:43
 **/
public class ClassAdviser extends Leader{
    @Override
    public void handleRequest(int days) {
        if(days <= 2){
            System.out.println("班主任批假"+days+"天");
        }else{
            if(getNext() != null){
                getNext().handleRequest(days);
            }else{
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
