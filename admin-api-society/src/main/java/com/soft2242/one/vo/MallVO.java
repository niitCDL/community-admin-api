package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "商铺列表")
public class MallVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 自增主键
     */
    @Schema(description = "id")

    private Long id;

    /**
     * 社区id
     */
    @Schema(description = "社区id")
    private Long communityId;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long userId;

    /**
     * 商铺编号
     */
    @Schema(description = "商铺编号")
    private String mallNumber;

    /**
     * 地址
     */
    @Schema(description = "地址")
    private String address;

    /**
     * 建筑面积
     */
    @Schema(description = "建筑面积")
    private Integer mallArea;

    /**
     * 商铺类型
     */
    @Schema(description = "商铺类型")
    private String mallType;

    /**
     * 商铺状态(0：未售出 1：已售出)
     */
    @Schema(description = "商铺状态(0：未售出 1：已售出)")
    private Integer mallStatus;

    /**
     * 删除标识（0：未删除 1：已删除）
     */
    @Schema(description = "删除标识（0：未删除 1：已删除）")
    private Integer deleted;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Long creator;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private Long updater;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
