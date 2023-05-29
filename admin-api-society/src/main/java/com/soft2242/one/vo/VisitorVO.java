package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data

@Schema(description = "访客开门登记")
public class VisitorVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "id")

    private Long id;

    /**
     * 绑定业主id
     */
    @Schema(description = "绑定业主id")
    private Integer ownerId;

    /**
     * 访客姓名
     */
    @Schema(description = "访客姓名")
    private String name;

    /**
     * 授权人手机号
     */
    @Schema(description = "授权人手机号")
    private String phone;

    /**
     * 门禁表主键，关联访客允许访问入口，用”,” 分割（1，2，3，4）
     */
    @Schema(description = "门禁表主键，关联访客允许访问入口，用”,” 分割（1，2，3，4）")
    private String doorIds;

    /**
     * 访问状态（0：已经访问1：未访问）
     */
    @Schema(description = "访问状态（0：已经访问1：未访问）")
    private Integer status;

    /**
     * 访问次数
     */
    @Schema(description = "访问次数")
    private Integer count;

    /**
     * 删除标识 0：正常 1：已删除
     */
    @Schema(description = "删除标识 0：正常 1：已删除")
    private Integer deleted;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")

    private LocalDateTime createTime;


    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Long creator;

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
