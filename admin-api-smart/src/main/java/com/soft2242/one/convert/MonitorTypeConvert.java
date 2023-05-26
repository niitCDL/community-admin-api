package com.soft2242.one.convert;

import com.soft2242.one.entity.MonitorTypeEntity;
import com.soft2242.one.vo.MonitorTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 监控分组
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface MonitorTypeConvert {
    MonitorTypeConvert INSTANCE = Mappers.getMapper(MonitorTypeConvert.class);

    MonitorTypeEntity convert(MonitorTypeVO vo);

    MonitorTypeVO convert(MonitorTypeEntity entity);

    List<MonitorTypeVO> convertList(List<MonitorTypeEntity> list);

}