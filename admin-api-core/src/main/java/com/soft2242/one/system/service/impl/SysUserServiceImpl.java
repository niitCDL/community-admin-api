package com.soft2242.one.system.service.impl;


import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.system.dao.SysUserDao;
import com.soft2242.one.system.dao.SysUserInfoDao;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 *
 * @author moqi
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserInfoDao, SysUserInfoEntity> implements SysUserService {

    public SysUserInfoEntity getUserInfoByAdminId(Long id){
        return baseMapper.getByAdminId(id);
    }

}
