package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.query.PatrolPointsQuery;
import com.soft2242.one.vo.CommunityVO;
import com.soft2242.one.vo.PatrolPointsVO;


import java.util.List;

/**
 * 巡更点表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface PatrolPointsService extends BaseService<PatrolPointsEntity> {

    PageResult<PatrolPointsVO> page(PatrolPointsQuery query);

    void save(PatrolPointsVO vo);

    /**
     * 下拉框使用
     * @param
     */
    List<CommunityVO> searchCommunity();

     PatrolPointsVO getById(Long id);
    void update(PatrolPointsVO vo);

    void delete(List<Long> idList);


}