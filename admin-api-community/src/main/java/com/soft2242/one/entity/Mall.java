package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 商铺表
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_mall")
public class Mall implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 社区id
     */
    private Long communityId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商铺编号
     */
    private String mallNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 建筑面积
     */
    private Integer mallArea;

    /**
     * 商铺类型
     */
    private String mallType;

    /**
     * 商铺状态(0：未售出 1：已售出)
     */
    private Byte mallStatus;

    /**
     * 删除标识（0：未删除 1：已删除）
     */
    private Byte deleted;

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
