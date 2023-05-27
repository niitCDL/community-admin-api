package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Mall;
import com.soft2242.one.query.MallQuery;
import com.soft2242.one.vo.MallVO;

/**
 * <p>
 * 商铺表 服务类
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */

public interface IMallService extends BaseService<Mall> {
    PageResult<MallVO> page(MallQuery query);

    void save(MallVO vo);

    void update(MallVO vo);

}
