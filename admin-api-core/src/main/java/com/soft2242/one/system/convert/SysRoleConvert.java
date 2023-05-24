package com.soft2242.one.system.convert;

import com.soft2242.one.system.entity.SysRoleEntity;
import com.soft2242.one.system.vo.SysRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author moqi
 */
@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleVO convert(SysRoleEntity entity);

    SysRoleEntity convert(SysRoleVO vo);

    List<SysRoleVO> convertList(List<SysRoleEntity> list);

}
