package com.soft2242.one.entity;

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
public class PatrolPointsEntity {
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
	* 删除标识（0：未删除，1：已删除）
	*/
	private Integer deleted;

	/**
	* 巡更点位置编号
	*/
	private String pointNumber;

	/**
	* 创建者
	*/
	private Long creator;

	/**
	* 经纬度坐标用","分隔
	*/
	private String coordinate;

	/**
	* 创建时间
	*/
	private Date createTime;

	/**
	* 修改者
	*/
	private Long updater;

	/**
	* 修改时间
	*/
	private Date updateTime;

}