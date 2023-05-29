package com.soft2242.one.convert;

import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.House;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.HouseVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName HouseConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/27 14:53
 */
@Mapper
public interface HouseConvert {
    HouseConvert INSTANCE = Mappers.getMapper(HouseConvert.class);
    HouseVO convert(House entity);

    House convert(HouseVO vo);

    List<HouseVO> convertList(List<House> list);
    List<House> convertListEntity(List<HouseVO> list);
}
