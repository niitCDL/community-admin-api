package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PatrolRecordsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author huang
 * @Description
 * @Date 2023 05 24 17 25
 **/
@Mapper
public interface PatrolRecordsDao extends BaseDao<PatrolRecordsEntity> {
    /**
     * 根据巡更点id查询所有的巡更记录
     * @param pointId 巡更点id
     * @return  巡更记录list
     */
    List<PatrolRecordsEntity> getRecordList(@Param("pointId") Long pointId);
}
