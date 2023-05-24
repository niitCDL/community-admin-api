package com.soft2242.one.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysLoginLogEntity;
import com.soft2242.one.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 *
 * @author mqxu
 */
@Mapper
public interface SysLoginLogDao extends BaseDao<SysLoginLogEntity> {

}