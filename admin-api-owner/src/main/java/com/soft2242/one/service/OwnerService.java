package com.soft2242.one.service;


import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.OwnerVO;
import com.soft2242.one.query.OwnerQuery;
import com.soft2242.one.entity.OwnerEntity;

import java.util.List;

/**
 * 业主表
 *
 * @author lsc lsc666@qq.com
 * @since 1.0.0 2023-05-28
 */
public interface OwnerService extends BaseService<OwnerEntity> {

    PageResult<OwnerVO> page(OwnerQuery query);
    OwnerVO findOwnerInfo(Long id);

    void save(OwnerVO vo);

    void update(OwnerVO vo);

    void delete(List<Long> idList);
}