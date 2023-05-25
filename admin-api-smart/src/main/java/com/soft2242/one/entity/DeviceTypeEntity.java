package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * 设备类别表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-25
 */

@Data
@TableName("t_device_type")
public class DeviceTypeEntity extends BaseEntity {
	/**
	* 类型名称
	*/
	private String type;

	/**
	* 类型描述
	*/
	private String des;

	/**
	* 是否启用 0-启用 1-禁用
	*/
	private Integer enabled;

	/**
	* 排序
	*/
	private Integer orderd;

}