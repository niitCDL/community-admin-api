package com.soft2242.one.service;

import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.entity.PatrolRecordsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 05 24 17 09
 **/
public interface PatrolPointsService{
    /**
     * 根据社区id获取相匹配的所有巡更点信息
     * @param communityId 社区id
     * @return 巡更点list
     */

    List<PatrolPointsEntity> getPointsList( Long  communityId);

    /**
     * 根据巡更点id查询所有的巡更记录
     * @param pointId 巡更点id
     * @return  巡更记录list
     */
    List<PatrolRecordsEntity> getRecordList(Long pointId);
}
