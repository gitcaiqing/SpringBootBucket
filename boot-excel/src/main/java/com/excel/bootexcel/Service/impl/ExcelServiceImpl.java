package com.excel.bootexcel.Service.impl;

import com.excel.bootexcel.Service.ExcelService;
import com.excel.bootexcel.util.ExcelExportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/12/19 18:40
 **/
@Service
public class ExcelServiceImpl implements ExcelService {
    /**
     * 导出含下拉框的excel
     * @param
     * @return java.lang.String
     * @author CQ
     * @date 2019/12/19 18:41
     */
    @Override
    public void exportContainsCheck(HttpServletRequest request, HttpServletResponse response) {

        String fileName = "export.xls";
        String sheetName = "第一页";

        List<String> titleList = Arrays.asList("类型");

        List<String> titleCodeList = Arrays.asList("L01");

        List<List<String>> paramList = new ArrayList();
        List<String> param = Arrays.asList("L01","L02","L03");
        paramList.add(param);

        HSSFWorkbook wb = ExcelExportUtil.createExcel(sheetName, titleList, titleCodeList, paramList);

        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            wb.write(output);
            output.flush();
            ExcelExportUtil.download(fileName, output.toByteArray(), request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
