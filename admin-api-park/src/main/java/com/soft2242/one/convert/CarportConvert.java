package com.soft2242.one.convert;

import com.soft2242.one.entity.Carport;
import com.soft2242.one.entity.Park;
import com.soft2242.one.vo.CarportVO;
import com.soft2242.one.vo.ParkVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName CarportConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 15:00
 */
@Mapper
public interface CarportConvert {
    CarportConvert INSTANCE = Mappers.getMapper(CarportConvert.class);

    Carport convert(CarportVO vo);

    CarportVO convert(Carport entity);

    List<CarportVO> convertList(List<Carport> list);
    List<Carport> convertListEntity(List<CarportVO> list);
}
