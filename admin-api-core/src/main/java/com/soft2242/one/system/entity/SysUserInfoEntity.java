package com.soft2242.one.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_admin_info")
public class SysUserInfoEntity extends BaseEntity {

    private Long adminId;
    private String realName;
    private String avatar;
    private Long postId;
    private Integer gender;
    private String email;
    private String vxAccount;
    private String jobNumber;
    private String nativePlace;
    private String graduateSchool;
    private Date graduateTime;
    private String education;
    private String major;
    private String remark;
    private Integer sort;
    private Date lastLoginTime;


}
