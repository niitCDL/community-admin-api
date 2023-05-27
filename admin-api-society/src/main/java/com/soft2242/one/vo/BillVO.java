package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "账单")
public class BillVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "id")

    private Long id;

    /**
     * 业主表主键
     */
    @Schema(description = "用户id")

    private Long userId;

    /**
     * 收费金额
     */
    @Schema(description = "收费金额")

    private Double money;

    /**
     * 缴费状态（0：缴费 1：未缴费）
     */
    @Schema(description = "缴费状态（0：缴费 1：未缴费）")

    private Integer status;

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
