package com.soft2242.one.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.system.convert.SysUserConvert;
import com.soft2242.one.system.convert.SysUserInfoConvert;
import com.soft2242.one.system.dao.SysUserRoleDao;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.entity.SysUserRoleEntity;
import com.soft2242.one.system.service.SysUserRoleService;
import com.soft2242.one.system.vo.SysUserInfoVO;
import com.soft2242.one.system.vo.SysUserVO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色关系
 *
 * @author moqi
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        // 数据库角色ID列表
        List<Long> dbRoleIdList = getRoleIdList(userId);

        // 需要新增的角色ID
        Collection<Long> insertRoleIdList = CollUtil.subtract(roleIdList, dbRoleIdList);
        if (CollUtil.isNotEmpty(insertRoleIdList)) {
            List<SysUserRoleEntity> roleList = insertRoleIdList.stream().map(roleId -> {
                SysUserRoleEntity entity = new SysUserRoleEntity();
                entity.setAdminId(userId);
                entity.setRoleId(roleId);
                return entity;
            }).collect(Collectors.toList());

            // 批量新增
            saveBatch(roleList);
        }

        // 需要删除的角色ID
        Collection<Long> deleteRoleIdList = CollUtil.subtract(dbRoleIdList, roleIdList);
        if (CollUtil.isNotEmpty(deleteRoleIdList)) {
            LambdaQueryWrapper<SysUserRoleEntity> queryWrapper = new LambdaQueryWrapper<>();
            remove(queryWrapper.eq(SysUserRoleEntity::getAdminId, userId).in(SysUserRoleEntity::getRoleId, deleteRoleIdList));
        }
    }

    @Override
    public void saveUserList(Long roleId, List<Long> userIdList) {
        List<SysUserRoleEntity> list = userIdList.stream().map(userId -> {
            SysUserRoleEntity entity = new SysUserRoleEntity();
            entity.setAdminId(userId);
            entity.setRoleId(roleId);
            return entity;
        }).collect(Collectors.toList());

        // 批量新增
        saveBatch(list);
    }

    @Override
    public void deleteByRoleIdList(List<Long> roleIdList) {
        remove(new LambdaQueryWrapper<SysUserRoleEntity>().in(SysUserRoleEntity::getRoleId, roleIdList));
    }

    @Override
    public void deleteByUserIdList(List<Long> userIdList) {
        remove(new LambdaQueryWrapper<SysUserRoleEntity>().in(SysUserRoleEntity::getAdminId, userIdList));
    }

    @Override
    public void deleteByUserIdList(Long roleId, List<Long> userIdList) {
        LambdaQueryWrapper<SysUserRoleEntity> queryWrapper = new LambdaQueryWrapper<>();
        remove(queryWrapper.eq(SysUserRoleEntity::getRoleId, roleId).in(SysUserRoleEntity::getAdminId, userIdList));
    }

    @Override
    public List<Long> getRoleIdList(Long userId) {
        return baseMapper.getRoleIdList(userId);
    }

    /**
     * 指定角色，获取该角色下的用户
     * @param roleId 角色id
     * @return
     */
    @Override
    public List<SysUserInfoVO> getUserListByRoleId(Long roleId) {
        List<SysUserInfoEntity> userList = baseMapper.getUserListByRoleId(roleId);
        return SysUserInfoConvert.INSTANCE.convertList(userList);
    }
}