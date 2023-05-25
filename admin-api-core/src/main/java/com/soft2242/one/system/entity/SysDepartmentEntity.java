package com.soft2242.one.system.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;

/**
 * 部门
 *
 * @author OM1GA soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("sys_department")
public class SysDepartmentEntity extends BaseEntity {

	/**
	* 父级部门ID
	*/
	private Long pid;

	/**
	* 部门名称
	*/
	private String name;

	/**
	* 部门描述
	*/
	private String remark;

	/**
	* 排序
	*/
	private String sort;

	/**
	 * 上级机构名称
	 */
	@TableField(exist = false)
	private String parentName;

}