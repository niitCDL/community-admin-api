package com.soft2242.one.service;

import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.PointsPathEntity;


import java.util.List;

/**
 * 巡更点和巡更线路关联业务接口
 * @author litao
 * @since 1.0.0 2023-05-25
 */
public interface PointsPathService extends BaseService<PointsPathEntity> {

    /**
     *根据巡更路线id，获取巡更点ID列表
     * @param pathId 路线ID
     * @return
     */
    List<Long> getPointIdList( Long pathId);

    /**
     *保存或修改，
     * @param pointIds
     * @param pathId
     */
    void saveOrUpdate(List<Long> pointIds,Long pathId);


    /**
     * 根据巡更点id，删除巡更点和路线之间的关系
     * @param pointIdList 巡更点
     */
    void deleteByPointId(List<Long> pointIdList);

    /**
     * 根据路线id,删除巡更点和路线之间的关系
     * @param pathId 路线id
     */
    void deleteByPathId(Long pathId);



}
