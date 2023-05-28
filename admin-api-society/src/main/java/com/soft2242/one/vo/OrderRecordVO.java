package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Author: James
 * Date: 2023/5/28 15:07
 * Describe:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "费用统计列表")
public class OrderRecordVO {

    @Schema(description = "社区表")
    private Long comminityId;

    /**
     * 账单表主键
     */
    @Schema(description = "房屋")
    private Long houseId;

    @Schema(description = "房屋地址")
    private String houseNumber;

    @Schema(description = "小区名字")
    private String communityName;

    @Schema(description = "水费")
    private Double waterFee;

    @Schema(description = "电费")
    private Double electricFee;

    @Schema(description = "物业费")
    private Double propertyFee;

    @Schema(description = "费用统计")
    private Double count;

    @Schema(description = "未完成")
    private Integer status1;

    @Schema(description = "已完成")
    private Integer status2;

    @Schema(description = "支付率")
    private Double percent;

    @Schema(description = "支付率")
    private LocalDateTime endTime;



}
