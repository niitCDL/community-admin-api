package com.soft2242.one.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@TableName("sys_admin_post")
public class SysAdminPostEntity extends BaseEntity {

    private Long postId;
    private Long adminId;

}
