package com.soft2242.one.convert;

import com.soft2242.one.entity.Activity;
import com.soft2242.one.vo.ActivityVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 社区活动
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface ActivityConvert {
    ActivityConvert INSTANCE = Mappers.getMapper(ActivityConvert.class);

    Activity convert(ActivityVO vo);

    ActivityVO convert(Activity entity);

    List<ActivityVO> convertList(List<Activity> list);

}