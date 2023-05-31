package com.soft2242.one.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.vo.SysUserInfoVO;
import com.soft2242.one.system.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author mqxu
 */
@Mapper
public interface SysUserInfoDao extends BaseDao<SysUserInfoEntity> {

    SysUserInfoEntity getByAdminId(Long id);

    List<SysUserInfoEntity> getByNotInAdminId(Long id);

    SysUserInfoVO getUserInfo(Long id);
    void recordLastLoginTime(@Param("lastLoginTime")String date, @Param("id")Long id);

    List<SysUserInfoVO> getList(Map<String, Object> params);

    List<SysUserVO> getList2();

    List<Long> getPostIdList(@Param("adminId") Long adminId);

    Long getDepartmentByAdminId(@Param("adminId") Long adminId);
}