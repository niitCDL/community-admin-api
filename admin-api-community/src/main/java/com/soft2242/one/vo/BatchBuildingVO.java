package com.soft2242.one.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fhs.core.trans.vo.TransPojo;
import com.soft2242.one.base.common.excel.DateConverter;
import com.soft2242.one.base.common.myexcel.MyExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BatchBuildingVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/27 16:33
 */
@Data
public class BatchBuildingVO implements Serializable, TransPojo {
    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    private Long id;
    @MyExcelProperty("社区ID")
    private Long communityId;
    @MyExcelProperty("楼宇名称")
    private String buildingName;
    @MyExcelProperty("所在单元")
    private Integer units;
    @MyExcelProperty("占地面积")
    private Integer usedArea;
    @MyExcelProperty("备注")
    private String content;

}
