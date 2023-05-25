package com.soft2242.one.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 巡更点表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "巡更点表")
public class PatrolPointsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "所属小区id（t_communtiy）")
	private Long communityId;

	@Schema(description = "巡更点名称")
	private String pointName;

	@Schema(description = "所在楼宇id（t_building）")
	private Long buildingId;

	@Schema(description = "状态（0：正常，1：禁用）")
	private Integer status;

	@Schema(description = "删除标识（0：未删除，1：已删除）")
	private Integer deleted;

	@Schema(description = "巡更点位置编号")
	private String pointNumber;

	@Schema(description = "创建者")
	private Long creator;

	@Schema(description = "经纬度坐标用','分隔")
	private String coordinate;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

	@Schema(description = "修改者")
	private Long updater;

	@Schema(description = "修改时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updateTime;


}