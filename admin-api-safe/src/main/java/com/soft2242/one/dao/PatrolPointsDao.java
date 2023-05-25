package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.entity.PatrolRecordsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 05 24 16 46
 **/
@Mapper
public interface PatrolPointsDao extends BaseDao<PatrolPointsEntity> {
    /**
     * 根据社区id获取相匹配的所有巡更点信息
     * @param communityId 社区id
     * @return 巡更点list
     */

    List<PatrolPointsEntity> getPointsList(@Param("communityId") Long  communityId);


}
