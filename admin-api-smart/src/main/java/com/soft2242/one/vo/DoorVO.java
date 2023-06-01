package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
* 门禁管理
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Data
@Schema(description = "门禁管理")
public class DoorVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "设备主键")
	private Long deviceId;

	@Schema(description = "设备")
	private String deviceName;

	@Schema(description = "门禁名称")
	private String doorName;

	@Schema(description = "门禁图片")
	private String doorImg;

	@Schema(description = "门禁状态")
	private Integer onlineStatus;

	@Schema(description = "所属小区")
	private Long communityId;

	@Schema(description = "所属小区")
	private String communityName;

	@Schema(description = "配置码")
	private String sysCode;
}