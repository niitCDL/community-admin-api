package com.soft2242.one.system.convert;


import com.soft2242.one.system.entity.SysLoginLogEntity;
import com.soft2242.one.system.vo.SysLoginLogExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysLoginLogConvert {
    SysLoginLogConvert INSTANCE = Mappers.getMapper(SysLoginLogConvert.class);
    List<SysLoginLogExcelVO> convertList(List<SysLoginLogEntity> selectList);
}
