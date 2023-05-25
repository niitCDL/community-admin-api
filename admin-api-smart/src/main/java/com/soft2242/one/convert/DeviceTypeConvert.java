package com.soft2242.one.convert;

import com.soft2242.one.entity.DeviceTypeEntity;
import com.soft2242.one.vo.DeviceTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 设备类别表
*
* @author Flobby 
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface DeviceTypeConvert {
    DeviceTypeConvert INSTANCE = Mappers.getMapper(DeviceTypeConvert.class);

    DeviceTypeEntity convert(DeviceTypeVO vo);

    DeviceTypeVO convert(DeviceTypeEntity entity);

    List<DeviceTypeVO> convertList(List<DeviceTypeEntity> list);

}