package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PointsPathEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointsPathDao extends BaseDao<PointsPathEntity> {

    List<Long> getPointIdList(@Param("pathId") Long pathId);




}
