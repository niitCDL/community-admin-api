package com.soft2242.one.system.convert;

import com.soft2242.one.system.entity.SysAdminDepartmentEntity;
import com.soft2242.one.system.vo.SysAdminDepartmentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 管理员部门关联表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface SysAdminDepartmentConvert {
    SysAdminDepartmentConvert INSTANCE = Mappers.getMapper(SysAdminDepartmentConvert.class);

    SysAdminDepartmentEntity convert(SysAdminDepartmentVO vo);

    SysAdminDepartmentVO convert(SysAdminDepartmentEntity entity);

    List<SysAdminDepartmentVO> convertList(List<SysAdminDepartmentEntity> list);

}