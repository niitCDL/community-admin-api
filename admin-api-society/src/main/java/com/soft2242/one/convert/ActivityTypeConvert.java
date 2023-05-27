package com.soft2242.one.convert;


import com.soft2242.one.entity.ActivityType;
import com.soft2242.one.vo.ActivityTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 活动分类
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface ActivityTypeConvert {
    ActivityTypeConvert INSTANCE = Mappers.getMapper(ActivityTypeConvert.class);

    ActivityType convert(ActivityTypeVO vo);

    ActivityTypeVO convert(ActivityType entity);

    List<ActivityTypeVO> convertList(List<ActivityType> list);

}