package com.soft2242.one.convert;

import com.soft2242.one.entity.Park;
import com.soft2242.one.vo.ParkVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 停车场表
*
* @author Dr.King whfplus7@163.com
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface ParkConvert {
    ParkConvert INSTANCE = Mappers.getMapper(ParkConvert.class);

    Park convert(ParkVO vo);

    ParkVO convert(Park entity);

    List<ParkVO> convertList(List<Park> list);

    List<Park> convertListEntity(List<ParkVO> list);

}