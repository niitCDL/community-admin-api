package com.soft2242.one.convert;

import com.soft2242.one.entity.Building;
import com.soft2242.one.vo.BatchBuildingVO;
import com.soft2242.one.vo.BuildingVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName BuildingConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/26 08:11
 */
@Mapper
public interface BuildingConvert {
    BuildingConvert INSTANCE = Mappers.getMapper(BuildingConvert.class);
    BuildingVO convert(Building entity);

    Building convert(BuildingVO vo);

    List<BuildingVO> convertList(List<Building> list);
    List<BatchBuildingVO> convert2List(List<Building> list);
    List<Building> convertListEntity(List<BatchBuildingVO> list);
}
