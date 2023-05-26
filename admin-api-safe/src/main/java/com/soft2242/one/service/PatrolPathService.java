package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.PatrolPathEntity;
import com.soft2242.one.query.PatrolPathQuery;
import com.soft2242.one.vo.*;

import java.util.List;

/**
 * 巡更路线表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface PatrolPathService extends BaseService<PatrolPathEntity> {

    PageResult<PatrolPathVO> page(PatrolPathQuery query);

    void save(PatrolPathVO vo);
    List<CommunityVO> searchCommunity();
    List<PatrolPointsVO> searchPoints();
    List<InspectionItemVO> searchItems();

    void update(PatrolPathVO vo);

    void delete(List<Long> idList);



}