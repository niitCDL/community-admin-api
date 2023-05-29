package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 楼宇表
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_building")
public class Building extends BaseEntity implements Serializable {

    @Serial
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
     * 楼宇名称
     */
    private String buildingName;

    /**
     * 层数
     */
    private Integer units;

    /**
     * 使用面积
     */
    private Integer usedArea;

    /**
     * 备注
     */
    private String content;

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
