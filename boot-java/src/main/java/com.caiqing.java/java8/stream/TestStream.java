package com.caiqing.java.java8.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.Test;
/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/9 13:25
 **/
public class TestStream {

    @Test
    public void test() {
        List<Plan> plans = new ArrayList<Plan>();
        plans.add(new Plan(1, "1a1", 0, new BigDecimal(11), 14L, new Date()));
        plans.add(new Plan(2, "1b1", 0, new BigDecimal(13), 17L, new Date()));
        plans.add(new Plan(3, "1c1", 1, new BigDecimal(19), 15L, new Date()));
        plans.add(new Plan(4, "1d1", 1, new BigDecimal(15), 13L, new Date()));
        plans.add(new Plan(5, "1e1", 2, new BigDecimal(14), 12L, new Date()));

        //把编号planNo转换大写 返回列表
        List<String> plans2 = plans.stream().map(p -> p.getPlanNo().toUpperCase()).collect(Collectors.toList());
        plans2.forEach(p -> System.out.println("把编号planNo转换大写:"+p));

        //价格由高到低排序
        List<Plan> plans3 = plans.stream().sorted( (a, b) -> b.getPrice().compareTo(a.getPrice()) ).collect(Collectors.toList());
        plans3.forEach(p -> System.out.println("价格由高到低排序:"+p));

        //求最高价/最低价/总价,   total数量平均,总和
        BigDecimal maxPrice = plans.stream().max( (a, b) -> a.getPrice().compareTo(b.getPrice()) ).get().getPrice();
        System.out.println("最高价:"+maxPrice);

        BigDecimal minPrice = plans.stream().min( (a, b) -> a.getPrice().compareTo(b.getPrice()) ).get().getPrice();
        System.out.println("最低价："+minPrice);

        //total总和
        Long total = plans.stream().mapToLong( Plan::getTotal).sum();
        System.out.println("total总和:"+total);

        //total平均
        Double avgTotal = plans.stream().mapToDouble( Plan::getTotal).average().getAsDouble();
        System.out.println("total平均:"+avgTotal);

        //转换成Map结构 <编号 ,  价格>
        Map<String, Object> map = plans.stream().collect(Collectors.toMap(p->p.getPlanNo(), p->p.getPrice()));
        System.out.println("转换成Map结构 <编号,价格>:"+map);

        //list 转 数组
        Plan[] planArr = plans.stream().toArray(Plan[]::new);
        System.out.println("转数组");
        Arrays.asList(planArr).stream().forEach(System.out::println);

        //按状态算数量的总和
        Map<Integer, Long> stateTotalSumMap = plans.stream().collect(Collectors.groupingBy(p->p.getState(), Collectors.summingLong(Plan::getTotal)));
        System.out.println("按状态算数量的总和:"+stateTotalSumMap);

        //按状态算数量的平均数
        Map<Integer, Double> stateTotalAvgMap = plans.stream().collect(Collectors.groupingBy(p->p.getState(), Collectors.averagingDouble(Plan::getTotal)));
        System.out.println("按状态算数量的平均数:"+stateTotalAvgMap);

        //LongSummaryStatistics描述流中元素的各种摘要数据,求 count, min, max, sum, and average.
        Map<Integer, LongSummaryStatistics> longSummaryStatisticsMap = plans.stream().collect(Collectors.groupingBy(p->p.getState(), Collectors.summarizingLong(Plan::getTotal)));
        System.out.println("LongSummaryStatistics描述流中元素的各种摘要数据:\r\n"+longSummaryStatisticsMap);

        List<Integer> collect = Arrays.asList(1,2,3,3,5,5,7);
        //去重
        List<Integer> collect1 = collect.stream().distinct().collect(Collectors.toList());
        System.out.println("去重:"+collect1);

        //不重复数据个数
        long count = collect.stream().distinct().count();
        System.out.println("不重复数据个数:"+count);

        //跳过前面3个数据
        List<Integer> collect2 = collect.stream().skip(3).collect(Collectors.toList());
        System.out.println("跳过前面3个数据:"+collect2);


    }
}
