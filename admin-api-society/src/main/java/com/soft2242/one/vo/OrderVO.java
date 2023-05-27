package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "订单列表")
public class OrderVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "id")
    private Long id;

    /**
     * 用户表主键
     */
    @Schema(description = "用户表主键")
    private Long userId;

    /**
     * 社区表
     */
    @Schema(description = "社区表")
    private Long comminityId;

    /**
     * 账单表主键
     */
    @Schema(description = "账单表主键")
    private Long billId;

    /**
     * 停车记录表id
     */
    @Schema(description = "停车记录表id")
    private Long parkRecordId;

    /**
     * 订单类型 0：购买车位订单1：租赁车位订单2：停车订单3：水费4：电费5：物业费
     */
    @Schema(description = "订单类型 0：购买车位订单1：租赁车位订单2：停车订单3：水费4：电费5：物业费")
    private Integer orderType;

    /**
     * 订单单价
     */
    @Schema(description = "订单单价")
    private String price;

    /**
     * 订单消费量，税费电费，物业费
     */
    @Schema(description = "订单消费量，税费电费，物业费")
    private Double amount;

    /**
     * 收费金额
     */
    @Schema(description = "收费金额")
    private Double money;

    /**
     * 订单状态（0：未完成 1：已完成）
     */
    @Schema(description = "订单状态（0：未完成 1：已完成）")
    private Integer status;

    /**
     * 支付时间
     */
    @Schema(description = "支付时间")
    private LocalDateTime payTime;

    /**
     * 删除标识 0：正常 1：已删除
     */
    @Schema(description = "删除标识 0：正常 1：已删除")
    private Integer deleted;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Long creator;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private Long updater;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;


    /**
     * 房屋表主键
     */
    @Schema(description = "房屋")
    private Long houseId;

    /**
     * 业主表主键
     */
    @Schema(description = "业主")
    private Long ownerId;

    @Schema(description = "订单结束时间")
    private LocalDateTime endTime;


}
