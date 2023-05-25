package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.DeviceTypeVO;
import com.soft2242.one.query.DeviceTypeQuery;
import com.soft2242.one.entity.DeviceTypeEntity;

import java.util.List;

/**
 * 设备类别表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-25
 */
public interface DeviceTypeService extends BaseService<DeviceTypeEntity> {

    PageResult<DeviceTypeVO> page(DeviceTypeQuery query);

    List<DeviceTypeEntity> availableList();

    void save(DeviceTypeVO vo);

    void update(DeviceTypeVO vo);

    void delete(List<Long> idList);
}