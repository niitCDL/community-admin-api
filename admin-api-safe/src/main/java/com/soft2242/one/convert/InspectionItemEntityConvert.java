package com.soft2242.one.convert;


import com.soft2242.one.entity.InspectionItemEntity;
import com.soft2242.one.vo.InspectionItemVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 巡检项目
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface InspectionItemEntityConvert {
    InspectionItemEntityConvert INSTANCE = Mappers.getMapper(InspectionItemEntityConvert.class);

    InspectionItemEntity convert(InspectionItemVO vo);

    InspectionItemVO convert(InspectionItemEntity entity);

    List<InspectionItemVO> convertList(List<InspectionItemEntity> list);

}