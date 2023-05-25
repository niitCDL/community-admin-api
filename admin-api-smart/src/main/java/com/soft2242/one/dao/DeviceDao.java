package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.DeviceEntity;
import com.soft2242.one.query.DeviceQuery;
import com.soft2242.one.vo.DeviceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 设备表
*
* @author Flobby
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface DeviceDao extends BaseDao<DeviceEntity> {

    List<DeviceVO> selectDeviceByPage(DeviceQuery query);

}