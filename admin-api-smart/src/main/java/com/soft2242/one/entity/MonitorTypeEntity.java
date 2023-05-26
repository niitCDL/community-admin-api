package com.soft2242.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 监控分组
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("t_monitor_type")
public class MonitorTypeEntity extends BaseEntity {

	/**
	* 类型名称
	*/
	private String type;

	/**
	* 类型描述
	*/
	private String des;

	/**
	* 排序
	*/
	private Integer orderd;

}