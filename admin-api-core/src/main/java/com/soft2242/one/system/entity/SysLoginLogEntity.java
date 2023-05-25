package com.soft2242.one.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.base.common.utils.DateUtils;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_system_operation_log")
public class SysLoginLogEntity {
    private Long id;
    private String loginTime;
    private String terminalType;
    private String browserType;
    private String os;
    private String deviceName;
    private String deviceMac;
    private String loginIp;
    private String address;
    private Integer deleted;
    private String createTime;

}
