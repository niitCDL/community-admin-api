package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 设备表
*
* @author Flobby
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "设备表")
public class DeviceVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "设备名称")
	private String deviceName;

	@Schema(description = "状态（0：正常 1：故障）")
	private Integer status;

	@Schema(description = "设备类别id")
	private Long deviceType;

	@Schema(description = "设备类别")
	private String deviceTypeName;

	@Schema(description = "设备所属小区id")
	private Long communityId;

	@Schema(description = "设备所属小区")
	private String communityName;

	@Schema(description = "设备位置")
	private String address;

	@Schema(description = "设备二维码url")
	private String qrCode;

	@Schema(description = "删除标识（0：未删除 1：已删除）")
	private Integer deleted;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;

	@Schema(description = "修改者")
	private Long updater;

}