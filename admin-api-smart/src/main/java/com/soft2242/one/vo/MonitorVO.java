package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
* 监控表
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Data
@Schema(description = "监控表")
public class MonitorVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "设备主键")
	private Long deviceId;

	@Schema(description = "设备名")
	private String deviceName;

	@Schema(description = "所属社区id")
	private Long communityId;

	@Schema(description = "小区名")
	private String communityName;

	@Schema(description = "监控名称")
	private String monitorName;

	@Schema(description = "状态（0：正常 1：故障）")
	private Integer status;

	@Schema(description = "0-启用 1-禁用")
	private Integer enabled;

	@Schema(description = "监控分组id")
	private Long monitorType;

	@Schema(description = "监控分组名")
	private String monitorTypeName;

	@Schema(description = "监控直播url")
	private String url;

	@Schema(description = "排序")
	private Integer orderd;

}