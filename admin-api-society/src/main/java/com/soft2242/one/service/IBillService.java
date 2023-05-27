package com.soft2242.one.service;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Bill;
import com.soft2242.one.query.BillQuery;
import com.soft2242.one.vo.BillVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */
public interface IBillService extends BaseService<Bill> {
    PageResult<BillVO> page(BillQuery query);

    void save(BillVO vo);

    void update(BillVO vo);

    void delete(List<Long> idList);
}
