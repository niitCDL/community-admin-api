package com.soft2242.one.convert;

import com.soft2242.one.entity.MonitorEntity;
import com.soft2242.one.vo.MonitorVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 监控表
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface MonitorConvert {
    MonitorConvert INSTANCE = Mappers.getMapper(MonitorConvert.class);

    MonitorEntity convert(MonitorVO vo);

    MonitorVO convert(MonitorEntity entity);

    List<MonitorVO> convertList(List<MonitorEntity> list);

}