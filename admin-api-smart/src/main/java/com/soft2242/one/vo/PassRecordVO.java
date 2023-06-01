package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 通行记录
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Data
@Schema(description = "通行记录")
public class PassRecordVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "用户")
	private String username;

	@Schema(description = "管理员名称")
	private String adminName;

	@Schema(description = "闸机id")
	private String doorName;

	@Schema(description = "出入方式 0-刷卡 1-人脸 2-指纹 3-管理员开门")
	private Integer passWay;

	@Schema(description = "小区")
	private String communityName;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

}