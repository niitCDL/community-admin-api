package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PatrolPathEntity;
import com.soft2242.one.vo.PatrolPathVO;
import com.soft2242.one.vo.PatrolPointsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* 巡更路线表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface PatrolPathDao extends BaseDao<PatrolPathEntity> {
    List<PatrolPathVO> getPathList(Map<String,Object> params);

    List<PatrolPathVO> getPathListByCommunityId(@Param("communityId") Long communityId);

}