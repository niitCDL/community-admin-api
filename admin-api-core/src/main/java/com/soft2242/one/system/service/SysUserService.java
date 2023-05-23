package com.soft2242.one.system.service;

import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;

public interface SysUserService extends BaseService<SysUserInfoEntity> {
    SysUserInfoEntity getUserInfoByAdminId(Long id);
}
