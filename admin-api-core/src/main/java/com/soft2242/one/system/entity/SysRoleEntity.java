package com.soft2242.one.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import com.soft2242.one.system.enums.DataScopeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月24日 14:49
 * @Description:
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 数据范围  {@link DataScopeEnum}
     */
    private Integer dataScope;
    /**
     * 机构ID
     */
    @TableField(fill = FieldFill.INSERT)
    private Long orgId;
}