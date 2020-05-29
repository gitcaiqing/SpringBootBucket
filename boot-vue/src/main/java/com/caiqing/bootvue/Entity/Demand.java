package com.caiqing.bootvue.Entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/3/2 13:32
 **/
@Data
public class Demand {

    private Long id;
    private String demandId;
    private String productionSiteName;
    private String dolphinVersion;
    private String deployType;
    private String ctServerOldVersion;
    private String ctServerNewVersion;
    private String status;
    private Date createDate;
    private Date updateDate;

}
