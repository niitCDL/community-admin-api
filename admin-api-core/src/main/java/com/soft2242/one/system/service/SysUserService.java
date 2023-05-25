package com.soft2242.one.system.service;

import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.vo.SysUserInfoVO;
import org.apache.ibatis.annotations.Param;

public interface SysUserService extends BaseService<SysUserInfoEntity> {
    SysUserInfoEntity getUserInfoByAdminId(Long id);

    void save(SysUserInfoVO user);

    void recordLastLoginTime(@Param("lastLoginTime")String date, @Param("id")Long id);

    String getTokenById(Long id);

    void changeAccountStatus(Long id, Integer accountStatus);

    void update(SysUserEntity sysUserEntity);
}
