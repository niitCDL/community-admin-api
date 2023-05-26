package com.soft2242.one.service;



import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.ComplaintEntity;
import com.soft2242.one.query.ComplaintQuery;
import com.soft2242.one.vo.ComplaintVO;

import java.util.List;

/**
 * 投诉
 *
 * @author xuelong
 * @since 1.0.0 2023-05-26
 */
public interface ComplaintService extends BaseService<ComplaintEntity> {

    PageResult<ComplaintVO> page(ComplaintQuery query);

    void save(ComplaintVO vo);

    void update(ComplaintVO vo);

    void delete(List<Long> idList);
}
