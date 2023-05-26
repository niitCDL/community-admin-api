package com.soft2242.one.vo;

import com.soft2242.one.base.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 分页巡更点表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@Schema(description = "分页巡更")
public class PatrolPointsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "所属小区id（t_communtiy")
	private Long communityId;

	@Schema(description = "所属小区名称")
	private  String communityName;


	@Schema(description = "所在楼宇id（t_building）")
	private Long buildingId;


	@Schema(description = "所属楼宇名称")
	private  String buildingName;

	@Schema(description = "单元号")
	private Integer units;
	@Schema(description = "巡更点名称")
	private String pointName;


	@Schema(description = "状态（0：正常，1：禁用）")
	private Integer status;



	@Schema(description = "巡更点位置编号")
	private String pointNumber;



	@Schema(description = "经纬度坐标用','分隔")
	private String coordinate;




}