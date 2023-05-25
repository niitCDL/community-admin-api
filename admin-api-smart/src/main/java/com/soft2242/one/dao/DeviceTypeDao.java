package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.DeviceTypeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 设备类别表
*
* @author Flobby 
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface DeviceTypeDao extends BaseDao<DeviceTypeEntity> {
	
}