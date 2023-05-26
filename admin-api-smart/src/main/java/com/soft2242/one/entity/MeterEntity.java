package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 仪表表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_meter")
public class MeterEntity extends BaseEntity {

	/**
	* 设备主键
	*/
	private Long deviceId;

	/**
	* 仪表名称
	*/
	private String meterName;

	/**
	* 所属小区id
	*/
	private Long communityId;

	/**
	* 仪表位置 0-房间表 1-公摊表
	*/
	private Integer meterType;

	/**
	* 价格
	*/
	private Double price;

	/**
	* 开始数值
	*/
	private Double startNum;

	/**
	* 当前数值
	*/
	private Double nowNum;

	/**
	* 最大数值
	*/
	private Double max;

	/**
	* 总用量
	*/
	private Double totalUse;

	/**
	* 在线状态 0-在线 1-离线
	*/
	private Integer onlineStatus;

	/**
	* 通电状态 0-合闸 1-关闸
	*/
	private Integer gateStatus;

}