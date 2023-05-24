package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author huang
 * @Description 巡更计划实体类
 * @Date 2023 05 24 15 41
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_patrol_plan")
public class PatrolPlanEntity extends BaseEntity {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 所属社区id
     */
    private Long communityId;

    /**
     * 巡更计划名称
     */
    private String planName;

    /**
     * 巡更路线id
     */
    private Long pathId;

    /**
     * 巡更人id
     */
    private Long inspectorId;


    /**
     * 拍照要求（0不要求拍照，1要求拍照）
     */
    private Integer photoRequirement;

    /**
     * 巡更周期
     */
    private  Integer planCycle;

    /**
     * 计划开始时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date startTime;

    /**
     * 计划结束时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date endTime;

    /**
     * 备注
     */
    private String note;
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
    private Long creator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改者
     */
    private Long updater;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;
}
