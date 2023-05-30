package com.soft2242.one.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;


/**
 * 巡更计划表
 *
 * @author litao soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_patrol_plan")
public class PatrolPlanEntity extends BaseEntity {

	/**
	* 小区id
	*/
	private Long communityId;


	/**
	* 巡更计划名
	*/
	private String planName;

	/**
	* 巡更路线id
	*/
	private Long pathId;

	/**
	* 巡更人id
	*/
	private Long inspectorId;

	/**
	* 拍照要求（0不要求拍照，1要求拍照）
	*/
	private Integer photoRequirement;

	/**
	* 巡更周期（0：每天，1：星期，2：月，3：年）
	*/
	private Integer planCycle;

	/**
	 *  计划开始日期
	 */
	private Date planStart;

	/**
	 * 上次执行时间
	 */
	private Date lastTime;


	/**
	* 计划开始时间
	*/
	private String startTime;

	/**
	* 计划结束时间
	*/
	private String endTime;

	/**
	* 备注
	*/
	private String notes;

	/**
	* 状态（0：正常，1：禁用）
	*/
	private Integer status;
}