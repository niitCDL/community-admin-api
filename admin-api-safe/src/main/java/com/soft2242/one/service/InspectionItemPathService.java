package com.soft2242.one.service;

import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.InspectionItemPathEntity;

import java.util.List;

/**
 * 巡检项目和巡更线路关联业务接口
 * @author litao
 * @since 1.0.0 2023-05-25
 */
public interface InspectionItemPathService extends BaseService<InspectionItemPathEntity> {

    /**
     *根据巡更路线id，获取巡检项目ID列表
     * @param pathId 路线ID
     * @return
     */
    List<Long> getInspectionItemIdList(Long pathId);

    /**
     *保存或修改，
     * @param inspectionItemIdList 巡检项目id列表
     * @param pathId
     */
    void saveOrUpdate(List<Long> inspectionItemIdList,Long pathId);


    /**
     * 根据巡检项目id，删除巡检项目和路线之间的关系
     * @param inspectionItemId 巡检项目id
     */
    void deleteByInspectionItemId(Long inspectionItemId);

    /**
     * 根据路线id,删除巡检项目和路线之间的关系
     * @param pathId 路线id
     */
    void deleteByPathId(Long pathId);
}
