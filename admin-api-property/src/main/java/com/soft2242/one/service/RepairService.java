package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.vo.RepairVO;

import java.util.List;

/**
 * 报修表
 *
 * @author xuelong
 * @since 1.0.0 2023-05-26
 */
public interface RepairService extends BaseService<RepairEntity> {

    PageResult<RepairVO> page(RepairQuery query);

    void save(RepairVO vo);

    void update(RepairVO vo);

    void delete(List<Long> idList);
}
