package com.soft2242.one.convert;


import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.vo.PatrolPointsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 巡更点表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface PatrolPointsConvert {
    PatrolPointsConvert INSTANCE = Mappers.getMapper(PatrolPointsConvert.class);

    PatrolPointsEntity convert(PatrolPointsVO vo);

    PatrolPointsVO convert(PatrolPointsEntity entity);

    List<PatrolPointsVO> convertList(List<PatrolPointsEntity> list);

}