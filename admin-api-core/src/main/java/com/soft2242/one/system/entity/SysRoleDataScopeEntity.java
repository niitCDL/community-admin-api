package com.soft2242.one.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色数据权限
 *
 * @author mqxu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_data_scope")
public class SysRoleDataScopeEntity extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 机构ID
     */
    @TableField(value = "department_id")
    private Long orgId;

}