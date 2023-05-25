package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备表
 *
 * @author Flobby
 * @since 1.0.0 2023-05-25
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_device")
public class DeviceEntity extends BaseEntity {

	/**
	* 设备名称
	*/
	private String deviceName;

	/**
	* 状态（0：正常 1：故障）
	*/
	private Integer status;

	/**
	* 设备类别id
	*/
	private Long deviceType;

	/**
	* 设备所属小区id
	*/
	private Long communityId;

	/**
	* 设备位置
	*/
	private String address;

	/**
	* 设备二维码url
	*/
	private String qrCode;

}