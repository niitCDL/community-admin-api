package com.soft2242.one.system.vo;

import com.soft2242.one.base.common.utils.MyExcelProperty;
import com.soft2242.one.base.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserExcelVO extends BaseEntity {
    /**
     * 用户名
     */
    @MyExcelProperty(value = "用户名")
    private String username;
    /**
     * 密码
     */
    @MyExcelProperty(value = "密码")
    private String password;

    /**
     * 手机号
     */
    @MyExcelProperty(value = "手机号")
    private String phone;

    /**
     * 超级管理员   0：否   1：是
     */
    @MyExcelProperty(value = "是否是超管")
    private Integer superAdmin;
    /**
     * 账号状态 (1:正常,2:停用,3:冻结,4:删除)
     */
    @MyExcelProperty(value = "账号状态")
    private Integer accountStatus;
    /**
     * 在线状态 (0：离线 1:在线)
     */
    @MyExcelProperty(value = "在线状态")
    private Integer onlineStatus;

    /**
     * token
     */
    @MyExcelProperty(value = "token认证")
    private String token;
}
