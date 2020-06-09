package com.caiqing.java.java8.stream;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/9 13:27
 **/
public class Plan {

    private int id;
    private String planNo;   //编号
    private Integer state;   //状态
    private BigDecimal price;//金额
    private long total;      //总数
    private Date createTime; //创建时间


    public Plan(int id, String planNo, Integer state, BigDecimal price, long total, Date createTime) {
        super();
        this.id = id;
        this.planNo = planNo;
        this.state = state;
        this.price = price;
        this.total = total;
        this.createTime = createTime;
    }
    public Plan() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPlanNo() {
        return planNo;
    }
    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Override
    public String toString() {
        return "Plan [id=" + id + ", planNo=" + planNo + ", state=" + state + ", price=" + price + ", total=" + total
                + ", createTime=" + createTime + "]";
    }

}
