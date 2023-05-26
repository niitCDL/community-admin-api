package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
* 仪表表
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Data
@Schema(description = "仪表表")
public class MeterVO implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "设备主键")
	private Long deviceId;

	@Schema(description = "设备名")
	private String deviceName;

	@Schema(description = "仪表名称")
	private String meterName;

	@Schema(description = "所属小区id")
	private Long communityId;

	@Schema(description = "小区名")
	private String communityName;

	@Schema(description = "仪表位置 0-房间表 1-公摊表")
	private Integer meterType;

	@Schema(description = "价格")
	private Double price;

	@Schema(description = "开始数值")
	private Double startNum;

	@Schema(description = "当前数值")
	private Double nowNum;

	@Schema(description = "最大数值")
	private Double max;

	@Schema(description = "总用量")
	private Double totalUse;

	@Schema(description = "在线状态 0-在线 1-离线")
	private Integer onlineStatus;

	@Schema(description = "通电状态 0-合闸 1-关闸")
	private Integer gateStatus;

	@Schema(description = "删除标识（0：未删除 1：已删除）")
	private Integer deleted;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "创建人")
	private Long creator;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;

	@Schema(description = "修改人")
	private Long updater;


}