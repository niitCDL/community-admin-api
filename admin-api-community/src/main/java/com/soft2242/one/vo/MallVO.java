package com.soft2242.one.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.myexcel.MyExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import javax.xml.transform.sax.SAXResult;
import java.io.Serial;
import java.util.Date;

/**
 * @ClassName MallVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/28 19:24
 */
@Data
@Schema(description = "商铺")
public class MallVO {
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
    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("用户ID")
    private Long userId;
    @Schema(description = "业主名", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("业主名")
    private String realName;
    @Schema(description = "商铺编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("商铺编号")
    private String mallNumber;
    @Schema(description = "地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("地址")
    private String address;
    @Schema(description = "使用面积", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("使用面积")
    private Integer mallArea;
    @Schema(description = "商铺类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("商铺类型")
    private String mallType;
    @Schema(description = "商铺状态(0：未售出 1：已售出)", requiredMode = Schema.RequiredMode.REQUIRED)
    @MyExcelProperty("商铺状态(0：未售出 1：已售出)")
    private Integer mallStatus;
    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createTime;
}
