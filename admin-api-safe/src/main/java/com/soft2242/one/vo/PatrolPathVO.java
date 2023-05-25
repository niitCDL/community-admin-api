package com.soft2242.one.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
* 巡更路线表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "巡更路线表")
public class PatrolPathVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "所属小区")
	private Long communityId;

	@Schema(description = "巡更路线名")
	private String wayName;

	@Schema(description = "定位距离(不能离开指定位置多少米)")
	private BigDecimal locationLength;

	@Schema(description = "状态（0：正常，1：禁用）")
	private Integer status;

	@Schema(description = "线路类型(0：巡更点类型，1：巡检项目类型)")
	private Integer type;

	@Schema(description = "删除标识（0：未删除，1：已删除）")
	private Integer deleted;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "修改者")
	private Long updater;

	@Schema(description = "修改时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;


}