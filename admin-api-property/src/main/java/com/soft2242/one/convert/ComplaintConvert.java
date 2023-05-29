package com.soft2242.one.convert;


import com.soft2242.one.entity.ComplaintEntity;
import com.soft2242.one.vo.ComplaintVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 投诉
*
* @author xuelong
* @since 1.0.0 2023-05-26
*/
@Mapper(uses = {MyMapper.class})
public interface ComplaintConvert {
    ComplaintConvert INSTANCE = Mappers.getMapper(ComplaintConvert.class);
    @Mapping(target = "employeeIds",source = "employeeIds",qualifiedByName = "convertToString")
    ComplaintEntity convert(ComplaintVO vo);
    @Mapping(target = "employeeIds",source = "employeeIds",qualifiedByName = "convertToArray")
    ComplaintVO convert(ComplaintEntity entity);
    @Mapping(target = "employeeIds",source = "employeeIds",qualifiedByName = "convertToArray")
    List<ComplaintVO> convertList(List<ComplaintEntity> list);

}
