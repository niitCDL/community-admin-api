package com.soft2242.one.system.convert;


import com.soft2242.one.system.entity.SysDictTypeEntity;
import com.soft2242.one.system.vo.SysDictTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author moqi
 */
@Mapper
public interface SysDictTypeConvert {
    SysDictTypeConvert INSTANCE = Mappers.getMapper(SysDictTypeConvert.class);

    SysDictTypeVO convert(SysDictTypeEntity entity);

    SysDictTypeEntity convert(SysDictTypeVO vo);

    List<SysDictTypeVO> convertList(List<SysDictTypeEntity> list);

}
