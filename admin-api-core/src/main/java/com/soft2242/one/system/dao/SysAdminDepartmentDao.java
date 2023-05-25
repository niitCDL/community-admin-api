package com.soft2242.one.system.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysAdminDepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 管理员部门关联表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface SysAdminDepartmentDao extends BaseDao<SysAdminDepartmentEntity> {
	List<Long> getAdminIdList(Long DId);
}