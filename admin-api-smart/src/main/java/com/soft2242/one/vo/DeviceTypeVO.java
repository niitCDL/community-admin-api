package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 设备类别表
*
* @author Flobby 
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "设备类别表")
public class DeviceTypeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "类型名称")
	private String type;

	@Schema(description = "类型描述")
	private String des;

	@Schema(description = "是否启用 0-启用 1-禁用")
	private Integer enabled;

	@Schema(description = "排序")
	private Integer orderd;

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

	@Schema(description = "修改责")
	private Long updater;


}