package com.soft2242.one.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.base.common.exception.ServerException;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.base.security.cache.TokenStoreCache;
import com.soft2242.one.base.security.user.SecurityUser;
import com.soft2242.one.system.dao.SysUserDao;
import com.soft2242.one.system.dao.SysUserInfoDao;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.enums.UserGenderEnum;
import com.soft2242.one.system.enums.UserOnlineEnum;
import com.soft2242.one.system.enums.UserStatusEnum;
import com.soft2242.one.system.service.SysUserService;
import com.soft2242.one.system.vo.SysUserInfoVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户管理
 *
 * @author moqi
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserInfoDao, SysUserInfoEntity> implements SysUserService {

    private SysUserDao sysUserDao;

    private SysUserInfoDao sysUserInfoDao;

    private final TokenStoreCache tokenStoreCache;

    public SysUserInfoEntity getUserInfoByAdminId(Long id){
        return baseMapper.getByAdminId(id);
    }

    @Override
    public void save(SysUserInfoVO user) {

        Date currentDate = new Date();
        Long creatorId = SecurityUser.getUserId();

        //保存到admin表中
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setId(sysUserDao.getMaxId() + 1);
        sysUserEntity.setUsername(user.getUsername());
        sysUserEntity.setPassword(user.getPassword());
        sysUserEntity.setAccountStatus(UserStatusEnum.ENABLED.getValue());
        sysUserEntity.setOnlineStatus(UserOnlineEnum.OFFLINE.getValue());
        sysUserEntity.setSuperAdmin(user.getSuperAdmin());
        sysUserEntity.setDeleted(0);
        sysUserEntity.setCreator(creatorId);
        sysUserEntity.setCreateTime(currentDate);
        sysUserEntity.setUpdater(creatorId);
        sysUserEntity.setUpdateTime(currentDate);
        sysUserDao.insert(sysUserEntity);

        //保存到sys_admin_info表中 提供默认名称与头像
        SysUserInfoEntity sysUserInfoEntity = new SysUserInfoEntity();
        sysUserInfoEntity.setAdminId(sysUserEntity.getId());
        sysUserInfoEntity.setRealName("默认用户名");
        sysUserInfoEntity.setAvatar("hangzhou.aliyuncs.com/avatar/me.png");
        sysUserInfoEntity.setSort(0);
        sysUserInfoEntity.setGender(UserGenderEnum.SECRET.getValue());
        sysUserInfoEntity.setDeleted(0);
        sysUserInfoEntity.setCreator(creatorId);
        sysUserInfoEntity.setCreateTime(currentDate);
        sysUserInfoEntity.setUpdater(creatorId);
        sysUserInfoEntity.setUpdateTime(currentDate);
        sysUserInfoDao.insert(sysUserInfoEntity);
    }

    @Override
    public void recordLastLoginTime(String date, Long id) {
        sysUserInfoDao.recordLastLoginTime(date,id);
    }

    /**
     * 修改用户状态
     * @param id 用户ID
     * @param accountStatus 用户状态
     */
    @Override
    public void changeAccountStatus(Long id,Integer accountStatus) {
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setId(id);
        sysUserEntity.setAccountStatus(accountStatus);
        if (UserStatusEnum.DISABLE.getValue() == accountStatus){
            tokenStoreCache.deleteUser(getTokenById(id));
            sysUserEntity.setToken("");
            sysUserEntity.setOnlineStatus(UserOnlineEnum.OFFLINE.getValue());
        }
        update(sysUserEntity);

    }

    @Override
    public void update(SysUserEntity sysUserEntity) {
        sysUserDao.updateById(sysUserEntity);
    }

    @Override
    public String getTokenById(Long id) {
        return sysUserDao.getTokenById(id);
    }

}
