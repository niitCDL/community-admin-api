package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.DoorVO;
import com.soft2242.one.query.DoorQuery;
import com.soft2242.one.entity.DoorEntity;

import java.util.List;

/**
 * 门禁管理
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
public interface DoorService extends BaseService<DoorEntity> {

    PageResult<DoorVO> page(DoorQuery query);

    void save(DoorVO vo);

    void update(DoorVO vo);

    void delete(List<Long> idList);
}