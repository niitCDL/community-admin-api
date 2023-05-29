package com.soft2242.one.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_post")
public class SysPostEntity extends BaseEntity {

    private String postCode;
    private String postName;
    private Integer sort;

}
