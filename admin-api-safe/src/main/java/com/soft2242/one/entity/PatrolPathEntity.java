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
 * @Description  巡更路线实体类
 * @Date 2023 05 24 15 30
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_patrol_path")
public class PatrolPathEntity extends BaseEntity {
    /**
     * 自增主键
     */
    private  Long id;

    /**
     * 所属社区id
     */
    private  Long communityId;

    /**
     * 巡更路线名称
     */
    private String wayName;

    /**
     * 定位距离(不能离开指定位置多少米)
     */
    private Double locationLength;

    /**
     * 状态（0：正常，1：禁用）
     */
    private Integer status;

    /**
     * 线路类型(0：巡更点类型，1：巡检项目类型)
     */
    private Integer type;

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
