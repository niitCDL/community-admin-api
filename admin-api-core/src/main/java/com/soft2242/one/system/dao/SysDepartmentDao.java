package com.soft2242.one.system.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysDepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 部门
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface SysDepartmentDao extends BaseDao<SysDepartmentEntity> {
    List<SysDepartmentEntity> getList(Map<String, Object> params);

    /**
     * 获取所有机构的id、pid列表
     */
    List<SysDepartmentEntity> getIdAndPidList();
}