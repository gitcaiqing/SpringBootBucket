package com.caiqing.java.设计模式.行为型.策略模式;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/6 14:36
 **/
public class Test {

    public static void main(String[] args) {
        List<Employ> employs = Arrays.asList(
                new Employ(18, 23d, "张三"),
                new Employ(28, 57d, "李四"),
                new Employ(38, 4d, "王五"),
                new Employ(3, 17d, "顺六"),
                new Employ(25, 63d, "田七")

        );

        //根据年龄获取
        List<Employ> employs1 = getEmployByFilter(employs, new EmployFilterByAge());
        System.out.println(employs1);
        //根据工资获取
        List<Employ> employs2 = getEmployByFilter(employs, new EmployFilterBySalary());
        System.out.println(employs2);

        //匿名内部类
        List<Employ> employs3 = getEmployByFilter(employs, new EmployStrategy() {
            @Override
            public boolean filterEmploy(Employ employ) {
                return employ.getAge() > 20;
            }
        });
        System.out.println(employs3);

        List<Employ> employs4 = getEmployByFilter(employs, new EmployStrategy() {
            @Override
            public boolean filterEmploy(Employ employ) {
                return employ.getSalary() > 20;
            }
        });
        System.out.println(employs4);

        //lambda
        List<Employ> employs5 = getEmployByFilter(employs, employ -> employ.getAge() > 20);
        System.out.println(employs5);

        List<Employ> employs6 = getEmployByFilter(employs, employ -> employ.getSalary() > 20);
        System.out.println(employs6);

    }

    public static List<Employ> getEmployByFilter(List<Employ> employs, EmployStrategy employStrategy){
        List<Employ> newEmploys = new ArrayList<>();
        for(Employ employ: employs){
            if(employStrategy.filterEmploy(employ)){
                newEmploys.add(employ);
            }
        }
        return newEmploys;
    }
}
