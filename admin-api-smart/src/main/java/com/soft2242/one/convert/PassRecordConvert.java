package com.soft2242.one.convert;

import com.soft2242.one.entity.PassRecordEntity;
import com.soft2242.one.vo.PassRecordVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 通行记录
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface PassRecordConvert {
    PassRecordConvert INSTANCE = Mappers.getMapper(PassRecordConvert.class);

    PassRecordEntity convert(PassRecordVO vo);

    PassRecordVO convert(PassRecordEntity entity);

    List<PassRecordVO> convertList(List<PassRecordEntity> list);

}