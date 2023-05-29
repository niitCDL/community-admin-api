package com.soft2242.one.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.myexcel.MyExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.util.Date;

/**
 * @ClassName BuildingVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/26 08:12
 */
@Data
@Schema(description = "楼宇")
public class BuildingVO {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    @ExcelIgnore
    private Long id;
    @Schema(description = "小区ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("小区ID")
    private Long communityId;
    @Schema(description = "小区名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("小区名称")
    private String communityName;
    @Schema(description = "楼宇名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("楼宇名称")
    private String buildingName;
    @Schema(description = "所在单元", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("层数")
    private Integer units;
    @Schema(description = "使用面积", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("占地面积")
    private Integer usedArea;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createTime;
    @Schema(description = "楼宇备注", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("备注")
    private String content;
}
