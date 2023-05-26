package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.MeterVO;
import com.soft2242.one.query.MeterQuery;
import com.soft2242.one.entity.MeterEntity;

import java.util.List;

/**
 * 仪表表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
public interface MeterService extends BaseService<MeterEntity> {

    PageResult<MeterVO> page(MeterQuery query);

    void save(MeterVO vo);

    void update(MeterVO vo);

    void delete(List<Long> idList);
}