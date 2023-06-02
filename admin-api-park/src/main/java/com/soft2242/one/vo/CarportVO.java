package com.soft2242.one.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.myexcel.MyExcelProperty;
import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CarportVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 15:06
 */
@Data
@Schema(description = "车位表")
public class CarportVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "自增主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "车辆id")
    @MyExcelProperty("车辆id")
    private Long carId;

    @Schema(description = "车牌号")
    @MyExcelProperty("车牌号")
    private String licence;

    @Schema(description = "业主id")
    @MyExcelProperty("业主id")
    private Long ownerId;

    @Schema(description = "业主姓名")
    @MyExcelProperty("业主姓名")
    private String realName;
    @Schema(description = "业主电话")
    @MyExcelProperty("业主电话")
    private String phone;

    @Schema(description = "停车场id")
    @MyExcelProperty("停车场id")
    private Long parkId;

    @Schema(description = "停车场名称")
    @MyExcelProperty("停车场名称")
    private String parkName;

    @Schema(description = "车位名称")
    @MyExcelProperty("车位名称")
    private String carportName;

    @Schema(description = "车位状态(0：闲置 1：已租 2：已售)")
    @MyExcelProperty("车位状态(0：闲置 1：已租 2：已售)")
    private Integer status;

    @Schema(description = "租赁(购买)开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @MyExcelProperty("租赁(购买)开始时间")
    private Date startTime;

    @Schema(description = "租赁(购买)结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @MyExcelProperty("租赁(购买)结束时间")
    private Date endTime;

//    @Schema(description = "删除标识（0：未删除 1：已删除）")
//    private Integer deleted;
//
//    @Schema(description = "创建者")
//    private Long creator;
//
//    @Schema(description = "创建时间")
//    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
//    private Date createTime;
//
//    @Schema(description = "更新者")
//    private Long updater;
//
//    @Schema(description = "更新时间")
//    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
//    private Date updateTime;
}
