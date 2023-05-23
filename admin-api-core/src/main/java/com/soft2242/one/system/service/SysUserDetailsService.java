package com.soft2242.one.system.service;


import com.soft2242.one.system.entity.SysUserEntity;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * SysUserDetailsService
 *
 * @author ao&dl
 */
public interface SysUserDetailsService {

    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
