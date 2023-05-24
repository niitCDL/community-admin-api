package com.soft2242.one.system.service;


import com.soft2242.one.system.vo.SysAccountLoginVO;
import com.soft2242.one.system.vo.SysTokenVO;

/**
 * 权限认证服务
 *
 * @author ao&dl
 */
public interface SysAuthService {

    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByAccount(SysAccountLoginVO login);

    void logout(String accessToken);
}
