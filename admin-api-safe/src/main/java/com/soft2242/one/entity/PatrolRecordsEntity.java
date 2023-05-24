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
 * @Description 巡更记录实体类
 * @Date 2023 05 24 15 57
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_patrol_records")
public class PatrolRecordsEntity extends BaseEntity {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 巡更计划id
     */
    private Long planId;

    /**
     * 巡更路线id
     */
    private Long pathId;

    /**
     * 巡更点id
     */
    private Long pointId;

    /**
     * 巡更人id
     */
    private Integer inspectorId;

    /**
     * 巡更提交时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date inspectorTime;


    /**
     * 巡更结果描述
     */
    private String inspectorResult;

    /**
     * 拍照要求（0不要求拍照，1要求拍照）
     */
    private Integer photoRequirement;

    /**
     * 拍照图片路径
     */

    private String photo;

    /**
     * 备注
     */

    private String notes;


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
