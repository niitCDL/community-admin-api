package com.soft2242.one.system.convert;

import com.soft2242.one.system.entity.SysPostEntity;
import com.soft2242.one.system.vo.SysPostVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 部门
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface SysPostConvert {
    SysPostConvert INSTANCE = Mappers.getMapper(SysPostConvert.class);

    SysPostEntity convert(SysPostVO vo);

    SysPostVO convert(SysPostEntity entity);

    List<SysPostVO> convertList(List<SysPostEntity> list);

}