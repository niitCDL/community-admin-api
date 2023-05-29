package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Carport
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 15:16
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_carport")
public class Carport {
    /**
     * 自增主键
     */
    @TableId
    private Long id;

    /**
     * 车辆id
     */
    private Long carId;

    /**
     * 业主id
     */
    private Long ownerId;

    /**
     * 停车场id
     */
    private Long parkId;

    /**
     * 车位名称
     */
    private String carportName;

    /**
     * 车位状态(0：闲置 1：已租 2：已售)
     */
    private Integer status;

    /**
     * 租赁(购买)开始时间
     */
    private Date startTime;

    /**
     * 租赁(购买)结束时间
     */
    private Date endTime;

    /**
     * 删除标识（0：未删除 1：已删除）
     */
    private Integer deleted;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者
     */
    private Long updater;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
