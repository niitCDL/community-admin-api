package com.soft2242.one.convert;

import com.soft2242.one.entity.DoorEntity;
import com.soft2242.one.vo.DoorReviewVO;
import com.soft2242.one.vo.DoorVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 门禁管理
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface DoorConvert {
    DoorConvert INSTANCE = Mappers.getMapper(DoorConvert.class);

    DoorEntity convert(DoorVO vo);

    DoorEntity convert(DoorReviewVO vo);

    DoorVO convert(DoorEntity entity);

    List<DoorVO> convertList(List<DoorEntity> list);

}