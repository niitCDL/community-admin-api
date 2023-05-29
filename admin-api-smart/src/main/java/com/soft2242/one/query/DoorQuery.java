package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 门禁管理查询
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "门禁管理查询")
public class DoorQuery extends Query {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "设备主键")
    private Long deviceId;

    @Schema(description = "门禁名称")
    private String doorName;

    @Schema(description = "所属小区")
    private Long communityId;

}