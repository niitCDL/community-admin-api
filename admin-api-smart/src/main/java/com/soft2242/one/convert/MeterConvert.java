package com.soft2242.one.convert;

import com.soft2242.one.entity.MeterEntity;
import com.soft2242.one.vo.MeterVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 仪表表
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface MeterConvert {
    MeterConvert INSTANCE = Mappers.getMapper(MeterConvert.class);

    MeterEntity convert(MeterVO vo);

    MeterVO convert(MeterEntity entity);

    List<MeterVO> convertList(List<MeterEntity> list);

}