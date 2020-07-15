package com.caiqing.java.设计模式.行为型.访问者模式;

/**
 * @Description 具体访问者：艺术企业
 * @Author CQ
 * @Date 2020/7/9 15:35
 **/
public class CompanyArt implements Company{
    @Override
    public String create(Paper paper) {
        return "艺术企业 造纸鹤";
    }

    @Override
    public String create(Cuprum cuprum) {
        return "艺术企业 造铜像";
    }
}
