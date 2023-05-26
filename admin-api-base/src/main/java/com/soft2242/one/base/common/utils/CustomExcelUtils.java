package com.soft2242.one.base.common.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CustomExcelUtils {
    public static void export(String toPath, List<?> data) throws Exception {
        Integer total = data.size();
        //创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet();
        //创建第一行row
        HSSFRow header = sheet.createRow(0);
        //创建单元格并插入表头
        HSSFCell cell = null;
        //表头信息
        List<String> infos = getHeader(data.get(0).getClass());
        for (int i = 0; i < infos.size(); i++) {
            cell = header.createCell(i);
            cell.setCellValue(infos.get(i));
        }
        //
        HSSFRow body = null;
        for (int i = 1; i <= total; i++) {
            Object ele = data.get(i - 1);
            body = sheet.createRow(i);
            Field[] declaredFields = ele.getClass().getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {
                Field declaredField = declaredFields[j];
                String getMethod = "get" + declaredField.getName().toUpperCase().charAt(0) + declaredField.getName().substring(1);
                Method declaredMethod = ele.getClass().getDeclaredMethod(getMethod);
                Object res = declaredMethod.invoke(ele);
                cell = body.createCell(j);
                String resValue = res != null ? res.toString() : "";
                cell.setCellValue(resValue);
            }
        }

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String timeStamp = format.format(date);
        String excelName = timeStamp + "-" + data.get(0).getClass().getSimpleName() + ".xls";
        //创建文件
        String filePath = new String(toPath + File.separator + excelName);
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //文件输出流
        try {
            FileOutputStream stream = new FileOutputStream(file);
            //写入
            workbook.write(stream);
            //关闭输出流
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getHeader(Class cz) {
        ArrayList<String> headers = new ArrayList<>();
        Field[] fields = cz.getDeclaredFields();
        for (Field field : fields) {
            boolean annotationPresent = field.isAnnotationPresent(MyExcelProperty.class);
            if (annotationPresent) {
                MyExcelProperty annotation = field.getAnnotation(MyExcelProperty.class);
                String value = annotation.value();
                headers.add(value);
            }
        }
        return headers;
    }

}
