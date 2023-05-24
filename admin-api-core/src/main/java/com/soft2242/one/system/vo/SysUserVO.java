package com.soft2242.one.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;

@Data
@Schema(description = "登录用户")
public class SysUserVO {

    @Serial
    private static final long serialVersionUID = 1L;


    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 超级管理员   0：否   1：是
     */
    private Integer superAdmin;
    /**
     * 账号状态 (1:正常,2:停用,3:冻结,4:删除)
     */
    private Integer accountStatus;
    /**
     * 在线状态 (0：离线 1:在线)
     */
    private Integer onlineStatus;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 在线状态 (0：保密 1:男 2:女)
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;
}
