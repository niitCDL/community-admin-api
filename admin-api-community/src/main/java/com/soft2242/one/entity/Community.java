package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 社区表
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_community")
public class Community implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 社区名称
     */
    private String communityName;

    /**
     * 所在地区
     */
    private String address;

    /**
     * 占地面积
     */
    private Integer coverArea;

    /**
     * 社区图片（英文逗号分割）
     */
    private String communityImgs;

    /**
     * 备注
     */
    private String content;

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
