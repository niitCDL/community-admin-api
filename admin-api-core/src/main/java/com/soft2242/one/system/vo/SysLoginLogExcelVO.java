package com.soft2242.one.system.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.soft2242.one.base.common.myexcel.MyExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录日志")
public class SysLoginLogExcelVO {

    @MyExcelProperty("登录时间")
    private String loginTime;
    @MyExcelProperty("终端类型")
    private String terminalType;
    @MyExcelProperty("浏览器类型")
    private String browserType;
    @MyExcelProperty("操作系统")
    private String os;
    @MyExcelProperty("设备名称")
    private String deviceName;
    @MyExcelProperty("MAC地址")
    private String deviceMac;
    @MyExcelProperty("登录IP")
    private String loginIp;
    @MyExcelProperty("登录地址")
    private String address;

    @MyExcelProperty("登录人ID")
    private Long creator;

    @MyExcelProperty("登录人名称")
    @TableField(exist = false)
    private String creatorName;
}
