package com.excel.bootexcel.util;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;


/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/12/19 16:32
 **/
public class ExcelExportUtil {

    public static final String USER_AGENT = "User-Agent";

    public static final String FIRE_FOX = "firefox";

    /**
     * @param sheetName sheet页名称
     * @param titleList 列名
     * @param titleCodeList 列名对应的code
     * @param parpamtsList 可选择参数列(需与列名一比一)
     */
    public static HSSFWorkbook createExcel(String sheetName, List<String> titleList, List<String> titleCodeList, List<List<String>> parpamtsList) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = setSheetBaseInfoExcel(sheetName,36,30,wb);

        CellStyle bodyStyle = getDefaultBodyStyle(sheet.getWorkbook());
        CellStyle dateStyle = getDefaultDatetimeStyle(sheet.getWorkbook());

        for(int i=0; i<titleList.size(); i++){
            Row row = sheet.createRow(i);
            setBodyCellValue(row, 0, titleList.get(i),bodyStyle, dateStyle);
        }

        int rowIndex = 1;
        int colIndex;

        for(int j=0; j<titleCodeList.size(); j++){
            Row row = sheet.createRow(rowIndex);
            colIndex = 0;
            setBodyCellValue(row, colIndex++, titleCodeList.get(j),bodyStyle, dateStyle);
        }

        //设置默认下拉内容
        if(parpamtsList!=null && parpamtsList.size()>0) {
            for(int i=0;i<parpamtsList.size();i++) {
                if(parpamtsList.get(i)==null || parpamtsList.get(i).size()<1) {
                    continue;
                }
                //设置下拉控制的范围
                CellRangeAddressList regions = new CellRangeAddressList(1, 5000, i, i);
                // 生成下拉框内容
                String[] strings = new String[parpamtsList.get(i).size()];
                parpamtsList.get(i).toArray(strings);
                DVConstraint constraint = DVConstraint.createExplicitListConstraint(strings);
                // 绑定下拉框和作用区域
                HSSFDataValidation data_validation = new HSSFDataValidation(regions, constraint);
                // 对sheet页生效
                sheet.addValidationData(data_validation);
            }
        }
        return wb;
    }

    public static void download(String title, byte[] output, HttpServletRequest request, HttpServletResponse response){
        BufferedOutputStream bos = null;
        try {
            // firefox浏览器
            if (request.getHeader(USER_AGENT).toLowerCase().indexOf(FIRE_FOX) > 0) {
                title = new String(title.getBytes("UTF-8"), "ISO8859-1");
            } else {
                // 其他浏览器包括IE浏览器和google浏览器
                title = URLEncoder.encode(title, "UTF-8");
            }
            response.setHeader("conent-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + title);
            bos = new BufferedOutputStream(response.getOutputStream());
            bos.write(output);
            bos.close();
        } catch (IOException e) {
        }finally {
            if(null != bos){
                try {
                    bos.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**设计excel定义列数、列宽和标头信息*/
    private static HSSFSheet setSheetBaseInfoExcel(String excelName,int columWith,int rowHight,HSSFWorkbook wb){
        HSSFSheet sheet = wb.createSheet(excelName);
        sheet.setDefaultColumnWidth(columWith);
        sheet.setDefaultRowHeightInPoints(rowHight);
//        String columWiths[] =  columWithMsg.split(",");
//        for (int i=0;i<columWiths.length;i++){
//            sheet.setColumnWidth(i,Integer.valueOf(columWiths[i])*512);
//        }
        return sheet;
    }

    /*
     * 列表首页的大title样式
     */
    private static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)16);
        //字体加粗
//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
//        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
//        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
//        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
//        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //设置背景颜色
//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        return style;
    }

    /*
     * 标题 列的样式
     */
    private static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 12);
        //字体加粗
//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
//        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
//        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
//        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
//        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //设置背景颜色
//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        return style;
    }

    private static CellStyle getDefaultBodyStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        return style;
    }

    public static CellStyle getDefaultDatetimeStyle(Workbook wb) {
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy HH:mm"));
        return cellStyle;
    }

    private static void setBodyCellValue(Row row, int colIndex, Object value, CellStyle textStyle, CellStyle dateStyle) {
        Cell cell = row.getCell(colIndex) == null ? row.createCell(colIndex) : row.getCell(colIndex);
        CellStyle newTextStyle = null == textStyle ? cell.getCellStyle() : textStyle;
        CellStyle newDateStyle = null == dateStyle ? cell.getCellStyle() : dateStyle;
        if (value == null) {
            cell.setCellValue("");
            cell.setCellStyle(newTextStyle);
        } else if (value instanceof String) {
            cell.setCellValue((String) value);
            cell.setCellStyle(newTextStyle);
        } else if (value instanceof Number) {
            cell.setCellValue(String.valueOf(value));
            cell.setCellStyle(newTextStyle);
        }
    }
}
