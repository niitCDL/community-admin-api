package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 门禁管理
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_door")
public class DoorEntity extends BaseEntity {

	/**
	* 设备主键
	*/
	private Long deviceId;

	/**
	* 门禁名称
	*/
	private String doorName;

	/**
	* 所属小区
	*/
	private Long communityId;

	/**
	* 配置码
	*/
	private String sysCode;

	/**
	* 允许欠费通行 0-允许 1-不允许
	*/
	private Integer allowOwed;

	/**
	* 允许访客通行  0-允许 1-不允许
	*/
	private Integer allowVisit;

	/**
	* 需要访客手机号 0-需要 1-不需要
	*/
	private Integer needTel;

	/**
	* 需要访客身份证 0-需要 1-不需要
	*/
	private Integer needIdCard;

	/**
	* 允许人脸识别 0-允许 1-不允许
	*/
	private Integer allowFace;

	/**
	* 允许指纹识别  0-允许 1-不允许
	*/
	private Integer allowFinger;

}