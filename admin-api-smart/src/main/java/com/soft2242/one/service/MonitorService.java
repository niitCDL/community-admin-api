package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.MonitorVO;
import com.soft2242.one.query.MonitorQuery;
import com.soft2242.one.entity.MonitorEntity;

import java.util.List;

/**
 * 监控表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
public interface MonitorService extends BaseService<MonitorEntity> {

    PageResult<MonitorVO> page(MonitorQuery query);

    void save(MonitorVO vo);

    void update(MonitorVO vo);

    void delete(List<Long> idList);
}