package com.soft2242.one.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.entity.SysUserInfoEntity;
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

    void recordLastLoginTime(@Param("lastLoginTime")String date, @Param("id")Long id);

    List<SysUserVO> getList(Map<String, Object> params);
}