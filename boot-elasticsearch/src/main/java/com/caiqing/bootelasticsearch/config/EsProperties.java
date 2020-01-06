package com.caiqing.bootelasticsearch.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description es配置内容
 * @Author CQ
 * @Date 2020/1/6 16:58
 **/
@ConfigurationProperties(prefix = "elasticsearch")
@Data
@Component
public class EsProperties {

    private String clusterName;

    private String clusterNodes;
}
