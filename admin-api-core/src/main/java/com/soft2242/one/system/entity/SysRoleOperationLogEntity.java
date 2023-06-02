package com.soft2242.one.system.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
/**
 * 角色操作记录表
 *
 * @author OM1GA soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("sys_role_operation_log")
public class SysRoleOperationLogEntity extends BaseEntity {

	/**
	* 操作
	*/
	private String operate;

	/**
	* 原因
	*/
	private String reason;

	/**
	 * 操作对象ID
	 */
	private Long operationObject;

	/**
	 * 操作对象名称
	 */
	@TableField(exist = false)
	private String operationObjectName;

	@TableField(exist = false)
	private String operatorName;

	@TableField(exist = false)
	private String updaterName;

}