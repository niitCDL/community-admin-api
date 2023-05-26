package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 仪表表查询
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "仪表表查询")
public class MeterQuery extends Query {
    @Schema(description = "仪表名称")
    private String meterName;

    @Schema(description = "所属小区id")
    private Long communityId;

    @Schema(description = "仪表位置 0-房间表 1-公摊表")
    private Integer meterType;

    @Schema(description = "在线状态 0-在线 1-离线")
    private Integer onlineStatus;

    @Schema(description = "通电状态 0-合闸 1-关闸")
    private Integer gateStatus;

}