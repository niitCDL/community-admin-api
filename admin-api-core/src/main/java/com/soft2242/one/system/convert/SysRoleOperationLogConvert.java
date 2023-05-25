package com.soft2242.one.system.convert;

import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import com.soft2242.one.system.vo.SysRoleOperationLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 角色操作记录表
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface SysRoleOperationLogConvert {
    SysRoleOperationLogConvert INSTANCE = Mappers.getMapper(SysRoleOperationLogConvert.class);

    SysRoleOperationLogEntity convert(SysRoleOperationLogVO vo);

    SysRoleOperationLogVO convert(SysRoleOperationLogEntity entity);

    List<SysRoleOperationLogVO> convertList(List<SysRoleOperationLogEntity> list);

}