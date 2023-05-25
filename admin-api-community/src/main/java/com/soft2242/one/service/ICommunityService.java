package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Community;
import com.soft2242.one.query.CommunityQuery;
import com.soft2242.one.vo.CommunityVO;

import java.util.List;

/**
 * <p>
 * 社区表 服务类
 * </p>
 *
 * @author Dr.king
 * @since 2023-05-25
 */
public interface ICommunityService extends BaseService<Community> {
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<CommunityVO> page(CommunityQuery query);

    /**
     * 获取所有通知数据
     *
     * @return list
     */
    List<CommunityVO> getList();

    /**
     * 新增通知
     *
     * @param vo vo
     */
    void save(CommunityVO vo);

    /**
     * 修改通知
     *
     * @param vo vo
     */
    void update(CommunityVO vo);

    /**
     * 根据id删除通知(批量删除)
     *
     * @param ids ids
     */
    void delete(List<Long> ids);
}
