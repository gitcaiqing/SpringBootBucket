package com.caiqing.java.设计模式.行为型.访问者模式;

import ch.qos.logback.classic.pattern.ClassNameOnlyAbbreviator;

/**
 * @Description 具体访问者：造币企业
 * @Author CQ
 * @Date 2020/7/9 15:36
 **/
public class CompanyMint implements Company {
    @Override
    public String create(Paper paper) {
        return "造币企业 造纸币";
    }

    @Override
    public String create(Cuprum cuprum) {
        return "造币企业 造铜钱";
    }
}
