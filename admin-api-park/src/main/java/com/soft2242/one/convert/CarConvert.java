package com.soft2242.one.convert;

import com.soft2242.one.entity.Car;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.vo.CarVO;
import com.soft2242.one.vo.CarportVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName CarConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 19:20
 */
@Mapper
public interface CarConvert {
    CarConvert INSTANCE = Mappers.getMapper(CarConvert.class);

    Car convert(CarVO vo);

    CarVO convert(Car entity);

    List<CarVO> convertList(List<Car> list);
    List<Car> convertListEntity(List<CarVO> list);
}
