package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.vo.PassReviewVO;
import com.soft2242.one.query.PassReviewQuery;
import com.soft2242.one.entity.PassReviewEntity;

import java.util.List;

/**
 * 门禁审核
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
public interface PassReviewService extends BaseService<PassReviewEntity> {

    PageResult<PassReviewVO> page(PassReviewQuery query);

    void save(PassReviewVO vo);

    void update(PassReviewVO vo);

    void delete(List<Long> idList);
}