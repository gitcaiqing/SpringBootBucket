package com.excel.bootexcel.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/12/19 18:40
 **/
public interface ExcelService {

    void exportContainsCheck(HttpServletRequest request, HttpServletResponse response);
}
