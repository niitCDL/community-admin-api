package com.soft2242.one.convert;


import com.soft2242.one.entity.PatrolPlanEntity;
import com.soft2242.one.vo.PatrolPlanVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 巡更计划表
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface PatrolPlanConvert {
    PatrolPlanConvert INSTANCE = Mappers.getMapper(PatrolPlanConvert.class);

    PatrolPlanEntity convert(PatrolPlanVO vo);

    PatrolPlanVO convert(PatrolPlanEntity entity);

    List<PatrolPlanVO> convertList(List<PatrolPlanEntity> list);

}