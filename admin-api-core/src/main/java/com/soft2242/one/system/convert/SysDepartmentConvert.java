package com.soft2242.one.system.convert;

import com.soft2242.one.system.entity.SysDepartmentEntity;
import com.soft2242.one.system.vo.SysDepartmentVO;
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
public interface SysDepartmentConvert {
    SysDepartmentConvert INSTANCE = Mappers.getMapper(SysDepartmentConvert.class);

    SysDepartmentEntity convert(SysDepartmentVO vo);

    SysDepartmentVO convert(SysDepartmentEntity entity);

    List<SysDepartmentVO> convertList(List<SysDepartmentEntity> list);

}