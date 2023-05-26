package com.soft2242.one.query;

import com.soft2242.one.base.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 设备表查询
*
* @author Flobby
* @since 1.0.0 2023-05-25
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "设备表查询")
public class DeviceQuery extends Query {
    @Schema(description = "设备名称")
    private String deviceName;

    @Schema(description = "状态（0：正常 1：故障）")
    private Integer status;

    @Schema(description = "设备类别id")
    private Long deviceType;

    @Schema(description = "设备位置")
    private String address;

}