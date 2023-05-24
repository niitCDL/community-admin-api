package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author huang
 * @Description 巡更点实体类
 * @Date 2023 05 24 15 55
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_patrol_points")
public class PatrolPointsEntity {
    /**
     * 自增主键
     */
    private  Long id;

    /**
     * 所属社区id
     */
    private  Long communityId;

    /**
     * 巡更点名称
     */
    private String pointName;



    /**
     * 状态（0：正常，1：禁用）
     */
    private Integer status;


    /**
     * 删除标识（0：未删除，1：已删除）
     */

    private Integer deleted;

    /**
     * 创建者
     */
    private  Long creator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改者
     */
    private  Long  updater;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT)
    private  Date updateTime;
}
