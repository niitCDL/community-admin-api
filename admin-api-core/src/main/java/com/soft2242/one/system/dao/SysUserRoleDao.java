package com.soft2242.one.system.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.entity.SysUserRoleEntity;
import com.soft2242.one.system.vo.SysUnbindingUserRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年05月24日 15:34
 * @Description:
 * @since: 1.0
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

    /**
     * 角色ID列表
     *
     * @param adminId 用户ID
     * @return 返回角色ID列表
     */
    List<Long> getRoleIdList(@Param("adminId") Long adminId);


    /**
     * 指定角色，获取该角色下的用户
     */
    List<SysUserInfoEntity> getUserListByRoleId(@Param("roleId") Long roleId);

    void unbindingUserAndRole(SysUnbindingUserRoleVO vo);
}
