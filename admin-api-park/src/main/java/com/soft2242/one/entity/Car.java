package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Car
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 19:17
 */
@Data
@TableName("t_car")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    /**
     * 自增主键
     */
    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 车牌号
     */
    private String licence;

    /**
     * 车辆品牌
     */
    private String brand;

    /**
     * 车辆型号
     */
    private String specification;

    /**
     * 车辆颜色
     */
    private String color;

    /**
     * 保险截止日期
     */
    private Date deadline;

    /**
     * 年审日期
     */
    private Date annualTime;

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
