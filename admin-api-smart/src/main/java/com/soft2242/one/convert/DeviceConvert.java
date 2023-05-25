package com.soft2242.one.convert;

import com.soft2242.one.entity.DeviceEntity;
import com.soft2242.one.vo.DeviceVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 设备表
*
* @author Flobby
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface DeviceConvert {
    DeviceConvert INSTANCE = Mappers.getMapper(DeviceConvert.class);

    DeviceEntity convert(DeviceVO vo);

    DeviceVO convert(DeviceEntity entity);

    List<DeviceVO> convertList(List<DeviceEntity> list);

}