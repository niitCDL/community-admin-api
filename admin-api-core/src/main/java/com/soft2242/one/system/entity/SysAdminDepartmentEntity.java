package com.soft2242.one.system.entity;

import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;

/**
 * 管理员部门关联表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("sys_admin_department")
public class SysAdminDepartmentEntity extends BaseEntity {

	/**
	* 管理员ID
	*/
	private Long adminId;

	/**
	* 管理员所属部门ID
	*/
	private Long departmentId;

}