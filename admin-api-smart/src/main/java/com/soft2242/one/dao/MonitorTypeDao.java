package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.MonitorTypeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 监控分组
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface MonitorTypeDao extends BaseDao<MonitorTypeEntity> {
	
}