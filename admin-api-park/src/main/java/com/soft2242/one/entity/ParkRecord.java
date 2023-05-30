package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ParkRecord
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/30 08:45
 */
@Data
@TableName("t_park_record")
public class ParkRecord {
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
     * 停车场id
     */
    private Long parkId;

    /**
     * 设备id
     */
    private Long doorId;

    /**
     * 进入时间
     */
    private Date accessTime;

    /**
     * 离开时间
     */
    private Date leaveTime;

    /**
     * 收费金额
     */
    private Double price;

    /**
     * 车辆类型（0：临时车辆 1：固定车辆）
     */
    private Integer type;

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
    private Date createTime;

    /**
     * 更新者
     */
    private Long updater;

    /**
     * 更新时间
     */
    private Date updateTime;
}
