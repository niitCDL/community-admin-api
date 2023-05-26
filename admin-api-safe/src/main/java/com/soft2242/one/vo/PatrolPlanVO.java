package com.soft2242.one.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 巡更计划表
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "巡更计划表")
public class PatrolPlanVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "小区id")
	private Long communityId;

	@Schema(description = "小区名称")
	private String communityName;

	@Schema(description = "巡更计划名")
	private String planName;

	@Schema(description = "巡更路线id")
	private Long pathId;

	@Schema(description = "巡更人id")
	private Long inspectorId;

	@Schema(description = "巡更人姓名")
	private String REALNAME;

	@Schema(description = "线路名称")
	private String wayName;

	@Schema(description = "拍照要求（0不要求拍照，1要求拍照）")
	private Integer photoRequirement;

	@Schema(description = "巡更周期（0：每天，1：星期，2：月，3：年）")
	private Integer planCycle;

	@Schema(description = "计划开始时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date startTime;

	@Schema(description = "计划结束时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date endTime;

	@Schema(description = "备注")
	private String notes;

	@Schema(description = "状态（0：正常，1：禁用）")
	private Integer status;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;
}