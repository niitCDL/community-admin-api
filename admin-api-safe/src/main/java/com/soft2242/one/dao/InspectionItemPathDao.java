package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.InspectionItemPathEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  巡检项目和巡更线路关联关系 Dao
 * @author litao
 * @since 1.0.0 2023-05-25
 */
@Mapper
public interface InspectionItemPathDao extends BaseDao<InspectionItemPathEntity> {
    /**
     * 根据路线id获取巡检项目id列表
     * @param pathId 巡更线路id
     * @return
     */
    List<Long> getInspectionItemIdList(@Param("pathId") Long pathId);
}
