package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.MonitorTypeVO;
import com.soft2242.one.query.MonitorTypeQuery;
import com.soft2242.one.entity.MonitorTypeEntity;

import java.util.List;

/**
 * 监控分组
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
public interface MonitorTypeService extends BaseService<MonitorTypeEntity> {

    PageResult<MonitorTypeVO> page(MonitorTypeQuery query);

    void save(MonitorTypeVO vo);

    void update(MonitorTypeVO vo);

    void delete(List<Long> idList);
}