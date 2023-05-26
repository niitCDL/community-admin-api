package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 监控表查询
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "监控表查询")
public class MonitorQuery extends Query {
    @Schema(description = "设备主键")
    private Long deviceId;

    @Schema(description = "监控名称")
    private String monitorName;

    @Schema(description = "所属小区id")
    private Long communityId;

    @Schema(description = "状态（0：正常 1：故障）")
    private Integer status;

    @Schema(description = "监控分组id")
    private Long monitorType;

}