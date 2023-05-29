package com.soft2242.one.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fhs.core.trans.vo.TransPojo;
import com.soft2242.one.base.common.myexcel.MyExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CommunityVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/25 14:03
 */
@Data
@Schema(description = "小区")
public class CommunityVO implements Serializable, TransPojo {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    @ExcelIgnore
    private Long id;

    @Schema(description = "小区名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("小区名称")
    private String communityName;

    @Schema(description = "小区地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("小区地址")
    private String address;

    @Schema(description = "小区面积", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("小区面积")
    private Integer coverArea;
    @Schema(description = "小区图片", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("小区图片")
    private String communityImgs;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createTime;
    @Schema(description = "小区备注", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("备注")
    private String content;

}
