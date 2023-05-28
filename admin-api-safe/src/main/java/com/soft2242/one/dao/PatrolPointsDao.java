package com.soft2242.one.dao;


import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.vo.PatrolPlanVO;
import com.soft2242.one.vo.PatrolPointsVO;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 巡更点表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface PatrolPointsDao extends BaseDao<PatrolPointsEntity> {
    List<PatrolPointsVO> getPointsList(Map<String,Object> params);

    PatrolPointsVO getById(Long id);


}