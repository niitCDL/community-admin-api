package com.soft2242.one.system.convert;

import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.system.entity.SysUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @author ao&dl
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    UserDetail convertDetail(SysUserEntity entity);

}
