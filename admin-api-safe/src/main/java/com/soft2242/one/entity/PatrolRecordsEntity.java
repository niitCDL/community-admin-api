package com.soft2242.one.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 巡更记录表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */

@Data
@TableName("t_patrol_records")
public class PatrolRecordsEntity {
	/**
	* 自增主键
	*/
	@TableId
	private Long id;

	/**
	* 巡更计划id
	*/
	private Long planId;

	/**
	* 巡更路线id
	*/
	private Long pathId;

	/**
	* 巡更点id
	*/
	private Long pointId;

	/**
	* 巡更人id
	*/
	private Long inspectorId;

	/**
	* 巡更提交时间
	*/
	private Date inspectorTime;

	/**
	* 巡更结果
	*/
	private String inspectorResult;

	/**
	* 拍照要求（0不要求拍照，1要求拍照）
	*/
	private Integer photoRequirement;

	/**
	* 图片路径，用逗号隔开
	*/
	private String photo;

	/**
	* 备注
	*/
	private String notes;

	/**
	* 状态（0：未完成，1：已完成）
	*/
	private Integer status;

	/**
	* 删除标识（0：未删除，1：已删除）
	*/
	private Integer deleted;

	/**
	* 创建者
	*/
	private Long creator;

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