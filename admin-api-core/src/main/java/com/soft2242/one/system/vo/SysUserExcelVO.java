package com.soft2242.one.system.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import com.fhs.core.trans.vo.TransPojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserExcelVO implements Serializable, TransPojo {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    private Long id;
    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    private String username;
    /**
     * 密码
     */
    @ExcelProperty(value = "密码")
    private String password;

    /**
     * 手机号
     */
    @ExcelProperty(value = "手机号")
    private String phone;

    /**
     * 超级管理员   0：否   1：是
     */
    @ExcelIgnore
    @Trans(type = TransType.DICTIONARY, key = "user_super_admin", ref = "superAdminLabel")
    private Integer superAdmin;

    @ExcelProperty(value = "是否是超管")
    private String superAdminLabel;

    /**
     * 账号状态 (1:正常,2:停用,3:冻结,4:删除)
     */
    @ExcelIgnore
    @Trans(type = TransType.DICTIONARY, key = "user_status", ref = "accountStatusLabel")
    private Integer accountStatus;

    /**
     * 对于账号状态的数据翻译
     */
    @ExcelProperty(value = "账号状态")
    private String accountStatusLabel;
    /**
     * 在线状态 (0：离线 1:在线)
     */
    @ExcelIgnore
    @Trans(type = TransType.DICTIONARY, key = "online_status", ref = "onlineStatusLabel")
    private Integer onlineStatus;

    /**
     * 在线状态数据说明
     */
    @ExcelProperty(value = "在线状态")
    private String onlineStatusLabel;

}
