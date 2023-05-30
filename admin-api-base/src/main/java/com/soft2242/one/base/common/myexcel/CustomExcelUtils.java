package com.soft2242.one.base.common.myexcel;

import com.soft2242.one.base.common.utils.HttpContextUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Component
@AllArgsConstructor
public class CustomExcelUtils {

    private Map<String, List<SysDictVO.DictData>> dictData;

    public void export(List<?> data) throws Exception {
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
        Integer columValue = 0;
        for (int i = 1; i <= total; i++) {
            columValue = 0;
            Object ele = data.get(i - 1);
            Class<?> eleClazz = ele.getClass();
            body = sheet.createRow(i);
            Field[] declaredFields = ele.getClass().getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {
                Field declaredField = declaredFields[j];
                if ("serialVersionUID".equals(declaredField.getName())) {
                    continue;
                }
                String getMethodName = "get" + declaredField.getName().toUpperCase().charAt(0) + declaredField.getName().substring(1);
                if (declaredField.isAnnotationPresent(MyTrans.class)) {
                    MyTrans myTrans = declaredField.getAnnotation(MyTrans.class);
                    String key = myTrans.key();
                    String ref = myTrans.ref();
                    List<SysDictVO.DictData> dictDataList = dictData.get(key);
                    String setMethodName = "set" + ref.toUpperCase().charAt(0) + ref.substring(1);
                    //得到枚举值
                    Method getMethod = eleClazz.getMethod(getMethodName);
                    //枚举值的翻译到对应的属性
                    Method setMethod = eleClazz.getMethod(setMethodName, eleClazz.getDeclaredField(ref).getType());
                    for (SysDictVO.DictData dictValue : dictDataList) {
                        if (Integer.valueOf(dictValue.getDictValue()) == getMethod.invoke(ele)) {
                            setMethod.invoke(ele, dictValue.getDictLabel());
                            break;
                        }
                    }
                } else if (declaredField.isAnnotationPresent(MyExcelProperty.class)) {
                    Method declaredMethod = eleClazz.getDeclaredMethod(getMethodName);
                    Object res = declaredMethod.invoke(ele);
                    cell = body.createCell(columValue);
                    String resValue = res != null ? res.toString() : "";
                    cell.setCellValue(resValue);
                    columValue++;
                }
            }
        }

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String timeStamp = format.format(date);
        String excelName = timeStamp + "-" + data.get(0).getClass().getSimpleName() + ".xls";
        String fileName = URLEncoder.encode(excelName, "UTF-8");
        //文件输出流
        try {
            HttpServletResponse response = HttpContextUtils.getHttpServletResponse();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename*=" + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            workbook.write(bos);
            bos.flush();
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


    public void importExcel(MultipartFile file, Class clazz,List dataList) throws Exception {
        InputStream inputStream = file.getInputStream();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            //工作表
            HSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();
            Object obj = null;
            Field[] declaredFields = clazz.getDeclaredFields();
            int cellIndex = 0;
            for (int i = 1; i < rows; i++) {
                HSSFRow row = sheet.getRow(i);
                cellIndex = 0;
                obj = clazz.getConstructor(null).newInstance();
                for (int j = 0; j < declaredFields.length; j++) {
                    System.out.println(cellIndex);
                    HSSFCell cell = row.getCell(cellIndex);
                    cell.setCellType(CellType.STRING);
                    Field field = declaredFields[j];
                    String fieldName = field.getName();
                    if ("serialVersionUID".equals(fieldName)) {
                        continue;
                    }
                    String setMethodName = "set" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1);
                    Class<?> type = field.getType();
                    Method setMethod = clazz.getMethod(setMethodName, type);
                    String getMethodName = "get" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1);
                    if (field.isAnnotationPresent(MyTrans.class)) {
                        MyTrans trans = field.getAnnotation(MyTrans.class);
                        String ref = trans.ref();
                        String key = trans.key();
                        //要从数据字典中拿到dictLabel所对应的dicValue
                        String dictValue = "";
                        List<SysDictVO.DictData> dictDataList = dictData.get(key);
                        for (SysDictVO.DictData data : dictDataList) {
                            if (data.getDictLabel().equals(cell.getStringCellValue())) {
                                dictValue = data.getDictValue();
                            }
                        }
                        Object parseValue = type.getConstructor(String.class).newInstance(dictValue);
                        setMethod.invoke(obj, parseValue);
                    } else if (field.isAnnotationPresent(MyExcelProperty.class)) {
                        Object parseValue = type.getConstructor(String.class).newInstance(cell.getStringCellValue());
                        setMethod.invoke(obj, parseValue);
                        cellIndex++;
                    }
                }
                dataList.add(obj);
            }
        } catch (Exception e) {
            System.out.println("导入失败");
            throw new RuntimeException(e);
        }
    }


}
