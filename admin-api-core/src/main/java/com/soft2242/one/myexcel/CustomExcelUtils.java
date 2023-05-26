package com.soft2242.one.myexcel;

import com.soft2242.one.system.vo.SysDictVO;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Component
@AllArgsConstructor
public class CustomExcelUtils {

    private Map<String,List<SysDictVO.DictData>> dictData;

    public void export(String toPath, List<?> data) throws Exception {
        System.out.println(dictData);
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
                String getMethodName = "get" + declaredField.getName().toUpperCase().charAt(0) + declaredField.getName().substring(1);
                if (declaredField.isAnnotationPresent(MyTrans.class)){
                    MyTrans myTrans = declaredField.getAnnotation(MyTrans.class);
                    String key = myTrans.key();
                    String ref = myTrans.ref();
                    List<SysDictVO.DictData> dictDataList = dictData.get(key);
                    String setMethodName = "set" + ref.toUpperCase().charAt(0) + ref.substring(1);
                    //得到枚举值
                    Method getMethod = eleClazz.getMethod(getMethodName);
                    //枚举值的翻译到对应的属性
                    Method setMethod = eleClazz.getMethod(setMethodName,eleClazz.getDeclaredField(ref).getType());
                    for (SysDictVO.DictData dictValue : dictDataList) {
                        if (Integer.valueOf(dictValue.getDictValue()) == getMethod.invoke(ele)) {
                            setMethod.invoke(ele,dictValue.getDictLabel());
                            break;
                        }
                    }
                }else {
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
