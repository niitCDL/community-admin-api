package com.soft2242.one.convert;

import com.soft2242.one.entity.UserEntity;
import com.soft2242.one.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 用户信息表
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserEntity convert(UserVO vo);

    UserVO convert(UserEntity entity);

    List<UserVO> convertList(List<UserEntity> list);

}