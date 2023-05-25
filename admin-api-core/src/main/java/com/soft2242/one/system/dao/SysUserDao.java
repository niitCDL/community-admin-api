package com.soft2242.one.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

/**
 * 系统用户
 *
 * @author mqxu
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {

    default SysUserEntity getByUsername(String username) {
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
    }
    Long getMaxId();

    String getTokenById(@Param("id") Long id);
}