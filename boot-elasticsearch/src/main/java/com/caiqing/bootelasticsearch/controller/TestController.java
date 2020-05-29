package com.caiqing.bootelasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/1/10 13:44
 **/
@RestController
@RequestMapping("/excel")
public class TestController {

    @RequestMapping("/exportContainsCheck")
    public String exportContainsCheck() {
        return "导出成功";
    }
}