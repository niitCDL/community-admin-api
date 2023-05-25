package com.soft2242.one.convert;

import com.soft2242.one.entity.PatrolPathEntity;
import com.soft2242.one.vo.PatrolPathVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 巡更路线表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface PatrolPathConvert {
    PatrolPathConvert INSTANCE = Mappers.getMapper(PatrolPathConvert.class);

    PatrolPathEntity convert(PatrolPathVO vo);

    PatrolPathVO convert(PatrolPathEntity entity);

    List<PatrolPathVO> convertList(List<PatrolPathEntity> list);

}