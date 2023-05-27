package com.soft2242.one.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: James
 * Date: 2023/5/26 19:24
 * Describe:
 */
@Data

public class OrderExcelVO implements Serializable , TransPojo {
    @Serial
    private static final long serialVersionUID = 1L;
    @ExcelIgnore
    private Long id;
    /**
     * 用户表主键
     */
    @ExcelProperty("用户id")
    private Long userId;
    /**
     * 社区表
     */
    @ExcelProperty("社区id")
    private Long comminityId;
    /**
     * 账单表主键
     */
    @ExcelProperty("账单id")
    private Long billId;
    /**
     * 停车记录表id
     */
    @ExcelProperty("停车记录id")
    private Long parkRecordId;
    /**
     * 订单类型 0：购买车位订单1：租赁车位订单2：停车订单3：水费4：电费5：物业费
     */
    @ExcelProperty("订单类型")
    private Integer orderType;
    /**
     * 订单单价
     */
    @ExcelProperty("订单单价")
    private String price;
    /**
     * 订单消费量，税费电费，物业费
     */
    @ExcelProperty("订单消费量")
    private Double amount;
    /**
     * 收费金额
     */
    @ExcelProperty("收费金额")
    private Double money;
    /**
     * 订单状态（0：未完成 1：已完成）
     */
    @ExcelProperty("订单状态")
    private Integer status;
    /**
     * 删除标识 0：正常 1：已删除
     */
    @ExcelProperty("删除标识")
    private Integer deleted;

    /**
     * 创建者
     */
    @ExcelProperty("创建者")
    private Long creator;

    /**
     * 更新者
     */
    @ExcelProperty("更新者")
    private Long updater;


    /**
     * 房屋表主键
     */
    @ExcelProperty("房屋表主键")
    private Long houseId;

    /**
     * 业主表主键
     */
    @ExcelProperty("业主表主键")
    private Long ownerId;


    @ExcelProperty("订单结束时间")
    private LocalDateTime endTime;



}
