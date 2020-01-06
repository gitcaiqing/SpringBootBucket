package com.excel.bootexcel.contorller;

import com.excel.bootexcel.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/12/19 18:38
 **/
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @RequestMapping("/exportContainsCheck")
    public String exportContainsCheck(HttpServletRequest request, HttpServletResponse response){
        excelService.exportContainsCheck(request, response);
        return "导出成功";
    }
}
