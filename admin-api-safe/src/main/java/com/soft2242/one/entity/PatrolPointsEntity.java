package com.soft2242.one.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 巡更点表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */

@Data
@TableName("t_patrol_points")
public class PatrolPointsEntity extends BaseEntity {
	/**
	* 自增主键
	*/
	@TableId
	private Long id;

	/**
	* 所属小区id（t_communtiy）
	*/
	private Long communityId;

	/**
	* 巡更点名称
	*/
	private String pointName;

	/**
	* 所在楼宇id（t_building）
	*/
	private Long buildingId;

	/**
	* 状态（0：正常，1：禁用）
	*/
	private Integer status;



	/**
	* 巡更点位置编号
	*/
	private String pointNumber;



	/**
	* 经纬度坐标用","分隔
	*/
	private String coordinate;



}