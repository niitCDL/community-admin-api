package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.DeviceVO;
import com.soft2242.one.query.DeviceQuery;
import com.soft2242.one.entity.DeviceEntity;

import java.util.List;

/**
 * 设备表
 *
 * @author Flobby
 * @since 1.0.0 2023-05-25
 */
public interface DeviceService extends BaseService<DeviceEntity> {

    PageResult<DeviceVO> page(DeviceQuery query);

    void save(DeviceVO vo);

    void update(DeviceVO vo);

    void delete(List<Long> idList);


}