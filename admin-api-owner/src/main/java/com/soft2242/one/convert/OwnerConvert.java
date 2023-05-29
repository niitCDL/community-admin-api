package com.soft2242.one.convert;

import com.soft2242.one.entity.OwnerEntity;
import com.soft2242.one.vo.OwnerVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 业主表
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@Mapper
public interface OwnerConvert {
    OwnerConvert INSTANCE = Mappers.getMapper(OwnerConvert.class);

    OwnerEntity convert(OwnerVO vo);

    OwnerVO convert(OwnerEntity entity);

    List<OwnerVO> convertList(List<OwnerEntity> list);

}