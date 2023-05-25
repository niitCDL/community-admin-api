package com.soft2242.one.system.convert;

import com.soft2242.one.system.entity.SysUserInfoEntity;
import com.soft2242.one.system.vo.SysUserInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author ao&dl
 */
@Mapper
public interface SysUserInfoConvert {
    SysUserInfoConvert INSTANCE = Mappers.getMapper(SysUserInfoConvert.class);

    SysUserInfoVO convert(SysUserInfoEntity entity);

}
