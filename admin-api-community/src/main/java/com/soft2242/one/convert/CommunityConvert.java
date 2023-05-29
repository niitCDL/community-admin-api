package com.soft2242.one.convert;

import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.Community;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.CommunityVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName CommunityConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/25 14:00
 */
@Mapper
public interface CommunityConvert {
    CommunityConvert INSTANCE = Mappers.getMapper(CommunityConvert.class);
    CommunityVO convert(Community entity);

    Community convert(CommunityVO vo);

    List<CommunityVO> convertList(List<Community> list);
    List<Community> convertListEntity(List<CommunityVO> list);
}
