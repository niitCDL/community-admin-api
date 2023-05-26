package com.soft2242.one.service;



import com.soft2242.one.entity.Visitor;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.query.VisitorQuery;
import com.soft2242.one.vo.VisitorVO;

/**
 * <p>
 * 服务类

/**
 * <p>

 * </p>
 *
 * @author ysh
 * @since 2023-05-25
 */


public interface IVisitorService extends BaseService<Visitor> {
    PageResult<VisitorVO> page(VisitorQuery query);

    void save(VisitorVO vo);

    void update(VisitorVO vo);

}
