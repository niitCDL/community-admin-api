package com.soft2242.one.convert;

import com.soft2242.one.entity.PassReviewEntity;
import com.soft2242.one.vo.PassReviewVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 门禁审核
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface PassReviewConvert {
    PassReviewConvert INSTANCE = Mappers.getMapper(PassReviewConvert.class);

    PassReviewEntity convert(PassReviewVO vo);

    PassReviewVO convert(PassReviewEntity entity);

    List<PassReviewVO> convertList(List<PassReviewEntity> list);

}