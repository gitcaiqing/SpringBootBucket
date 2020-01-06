package com.caiqing.bootelasticsearch.controller;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/1/6 16:18
 **/
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private TransportClient transportClient;

}
