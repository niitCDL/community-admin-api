package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName ParkRecordVO
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/30 08:40
 */
@Data
@Schema(description = "停车记录表")
public class ParkRecordVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "自增主键")
    private Long id;

    @Schema(description = "车辆id")
    private Long carId;
    @Schema(description = "车牌号")
    private String licence;

    @Schema(description = "停车场id")
    private Long parkId;

    @Schema(description = "停车场名称")
    private String parkName;

    @Schema(description = "设备id")
    private Long doorId;

    @Schema(description = "设备名")
    private String doorName;

    @Schema(description = "进入时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date accessTime;

    @Schema(description = "离开时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date leaveTime;

    @Schema(description = "收费金额")
    private Double price;

    @Schema(description = "车辆类型（0：临时车辆 1：固定车辆）")
    private Integer type;

    @Schema(description = "删除标识（0：未删除 1：已删除）")
    private Integer deleted;

    @Schema(description = "创建者")
    private Long creator;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createTime;

    @Schema(description = "更新者")
    private Long updater;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date updateTime;
}
