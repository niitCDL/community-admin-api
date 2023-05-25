package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 设备类别表查询
*
* @author Flobby 
* @since 1.0.0 2023-05-25
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "设备类别表查询")
public class DeviceTypeQuery extends Query {
    @Schema(description = "类型名称")
    private String type;

    @Schema(description = "类型描述")
    private String des;

    @Schema(description = "是否启用 0-启用 1-禁用")
    private Integer enabled;

}