package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 监控表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_monitor")
public class MonitorEntity extends BaseEntity {

	/**
	* 设备主键
	*/
	private Long deviceId;

	/**
	 * 所属社区id
	 */
	private Long communityId;

	/**
	* 监控名称
	*/
	private String monitorName;

	/**
	* 状态（0：正常 1：故障）
	*/
	private Integer status;

	/**
	* 0-启用 1-禁用
	*/
	private Integer enabled;

	/**
	* 监控分组id
	*/
	private Long monitorType;

	/**
	* 监控直播url
	*/
	private String url;

	/**
	* 排序
	*/
	private Integer orderd;

}