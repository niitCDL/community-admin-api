package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "访客邀请")

public class VisitorInvitationVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    /**
     * 访客表主键
     */
    @Schema(description = "访客表主键")
    private Long visitorId;

    /**
     * 绑定业主id
     */
    @Schema(description = "绑定业主id")
    private Long userId;


    /**
     * 门禁表主键，关联访客允许访问入口，用”,” 分割（1，2，3，4）
     */
    @Schema(description = "门禁表主键，关联访客允许访问入口，用”,” 分割（1，2，3，4）")
    private String doorIds;

    /**
     * 访问结束时间，判断是否可访问
     */
    @Schema(description = "访问结束时间，判断是否可访问")
    private LocalDateTime endTime;

    /**
     * 状态（0：正常 1：禁用），判断是否可访问
     */
    @Schema(description = "状态（0：正常 1：禁用），判断是否可访问")
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

    @Schema(description = "房屋id")
    private Long houseId;
    @Schema(description = "房屋编号")
    private String houseNumber;

    @Schema(description = "社区")
    private String communityName;

    @Schema(description = "有效时间")
    private String  validTime;

    @Schema(description = "访问次数")
    private Integer count;
    @Schema(description = "授权人")
    private String owner;

}
