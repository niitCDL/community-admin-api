package com.soft2242.one.system.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 角色操作记录表
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface SysRoleOperationLogDao extends BaseDao<SysRoleOperationLogEntity> {
	
}