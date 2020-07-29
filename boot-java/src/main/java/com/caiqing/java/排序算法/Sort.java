package com.caiqing.java.排序算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 冒泡排序
 * @Author CQ
 * @Date 2020/7/23 13:45
 **/
public class Sort {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(53,13,165,21,6465,546,4654,46,8,77);
        System.out.println("当前集合："+list);
        //冒泡排序
        //bubbleSort(list);

        //选择排序
        //selectSort(list1);

        //插入排序
        //insertSort(list2);

        //插入排序
        xierSort(list);
    }

    /**
     * 冒泡排序
     * @param
     * @return java.util.List<java.lang.Integer>
     * @author CQ
     * @date 2020/7/23 14:47
     */
    public static List<Integer> bubbleSort(List<Integer> list){
        System.out.println("当前集合："+list);

        for(int i=0; i<list.size(); i++){
            System.out.println("i=="+i);
            for(int j=0; j<list.size()-1-i; j++){
                System.out.println("j==="+j);
                //后一个小于前面的，则将后面的往前移
                if(list.get(j+1) < list.get(j)){
                    //后面的值赋值给临时变量
                    int tmp = list.get(j+1);
                    //前面的较大的值赋给后1位
                    list.set(j+1, list.get(j));
                    //转存的临时变量赋值给当前遍历到的下标位置
                    list.set(j, tmp);
                    System.out.println("当前排序："+list);
                }
            }

        }

        System.out.println("排序集合："+list);
        return list;
    }

    /**
     * 选择排序
     * @param list
     * @return java.util.List<java.lang.Integer>
     * @author CQ
     * @date 2020/7/23 14:47
     */
    public static List<Integer> selectSort(List<Integer> list){



        System.out.println("当前集合："+list);

        for(int i = 0; i < list.size(); i++){
            System.out.println("i=="+i);
            int minIndex = i;
            for(int j = i; j < list.size(); j++){
                System.out.println("j==="+j);
                if(list.get(j) < list.get(minIndex)){
                    //当前最小
                    minIndex = j;
                }

            }

            //最小值
            int tmp = list.get(minIndex);

            //相对较大的数放到 当前遍历到的最新值的地方
            list.set(minIndex, list.get(i));

            //最小值放在当前遍历位置
            list.set(i, tmp);
            System.out.println("当前排序："+list);
        }

        System.out.println("排序集合："+list);
        return list;
    }

    /**
     * 插入排序
     *
     * @param list
     * @return java.util.List<java.lang.Integer>
     * @author CQ
     * @date 2020/7/23 15:35
     */
    public static List<Integer> insertSort(List<Integer> list){

        System.out.println("当前集合："+list);

        int current;

        for(int i = 0; i < list.size() -1; i++){

            //取出当前需要拿来排序的数据
            current = list.get(i+1);

            //前一个索引值
            int preIndex = i;

            //当前值 小于 前一个值， 则将其插入到 那个较大值的后面

            while(preIndex >= 0 &&  current < list.get(preIndex)){
                //较大值往后移1位
                list.set(preIndex + 1, list.get(preIndex));

                preIndex--;
            }

            list.set(preIndex + 1, current);
            System.out.println("当前排序："+list);
        }

        System.out.println("排序集合："+list);
        return list;
    }


    public static List<Integer> xierSort(List<Integer> list){

        int size = list.size();
        int temp, gap = size / 2;
        int count = 0;
        while (gap > 0){
            System.out.println("gap:"+gap);
            for(int i = gap; i < size; i++){
                temp = list.get(i);
                int preIndex = i - gap;
                while(preIndex >=0 && list.get(preIndex) >temp){
                    list.set((preIndex+gap), list.get(preIndex));
                    preIndex -= gap;
                }
                list.set(preIndex+gap, temp);
                count++;
                System.out.println("当前排序+"+count+"次："+ list);
            }
            gap /= 2;
        }
        return list;
    }

}
