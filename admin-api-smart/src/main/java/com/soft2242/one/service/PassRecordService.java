package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.PassRecordEntity;
import com.soft2242.one.query.PassRecordQuery;
import com.soft2242.one.vo.PassRecordVO;

/**
 * 通行记录
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
public interface PassRecordService extends BaseService<PassRecordEntity> {

    PageResult<PassRecordVO> page(PassRecordQuery query);

}