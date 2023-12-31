package com.soft2242.one.system.service.impl;

import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.system.convert.SysUserConvert;
import com.soft2242.one.system.dao.SysRoleDao;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.enums.DataScopeEnum;
import com.soft2242.one.system.enums.UserStatusEnum;
import com.soft2242.one.system.service.SysDepartmentService;
import com.soft2242.one.system.service.SysMenuService;
import com.soft2242.one.system.service.SysUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户 UserDetails 信息
 *
 * @author ao&dl
 */
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements SysUserDetailsService {

    private final SysMenuService sysMenuService;
    private final SysRoleDao sysRoleDao;
    private final SysDepartmentService sysDepartmentService;
    @Override
    public UserDetails getUserDetails(SysUserEntity userEntity) {
        // 转换成UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertDetail(userEntity);

        // 账号不可用
        if (userEntity.getAccountStatus() == UserStatusEnum.DISABLE.getValue()) {
            userDetail.setEnabled(false);
        }

        System.out.println(userEntity);
        // 数据权限范围
        List<Long> dataScopeList = getDataScope(userDetail);
        userDetail.setDataScopeList(dataScopeList);

        // 用户权限列表
        Set<String> authoritySet = sysMenuService.getUserAuthority(userDetail);
        userDetail.setAuthoritySet(authoritySet);

        return userDetail;
    }

    private List<Long> getDataScope(UserDetail userDetail) {
        Integer dataScope = sysRoleDao.getDataScopeByUserId(userDetail.getId());
        if (dataScope == null) {
            return new ArrayList<>();
        }

        if (dataScope.equals(DataScopeEnum.ALL.getValue())) {
            // 全部数据权限，则返回null
            return null;
        } else if (dataScope.equals(DataScopeEnum.ORG_AND_CHILD.getValue())) {
            // 本机构及子机构数据
            List<Long> dataScopeList = sysDepartmentService.getSubOrgIdList(userDetail.getOrgId());
            // 自定义数据权限范围

            return dataScopeList;
        } else if (dataScope.equals(DataScopeEnum.ORG_ONLY.getValue())) {
            // 本机构数据
            List<Long> dataScopeList = new ArrayList<>();
            dataScopeList.add(userDetail.getOrgId());
            // 自定义数据权限范围

            return dataScopeList;
        } else if (dataScope.equals(DataScopeEnum.CUSTOM.getValue())) {
            // 自定义数据权限范围
        }

        return new ArrayList<>();
    }
}
