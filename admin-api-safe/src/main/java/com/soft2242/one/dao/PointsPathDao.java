package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PointsPathEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  巡更点和巡更线路关联关系 Dao
 * @author litao
 */
@Mapper
public interface PointsPathDao extends BaseDao<PointsPathEntity> {

    /**
     * 根据路线id获取巡更点id列表
     * @param pathId 巡更线路id
     * @return
     */
    List<Long> getPointIdList(@Param("pathId") Long pathId);
}
