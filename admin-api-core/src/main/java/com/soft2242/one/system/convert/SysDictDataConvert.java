package com.soft2242.one.system.convert;

import com.soft2242.one.base.common.myexcel.SysDictVO;
import com.soft2242.one.system.entity.SysDictDataEntity;
import com.soft2242.one.system.vo.SysDictDataVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author moqi
 */
@Mapper
public interface SysDictDataConvert {
    SysDictDataConvert INSTANCE = Mappers.getMapper(SysDictDataConvert.class);

    SysDictDataVO convert(SysDictDataEntity entity);

    SysDictDataEntity convert(SysDictDataVO vo);

    List<SysDictDataVO> convertList(List<SysDictDataEntity> list);

    List<SysDictVO.DictData> convertList2(List<SysDictDataEntity> list);

}
