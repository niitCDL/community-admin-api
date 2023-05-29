package com.soft2242.one.convert;

import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.vo.RepairVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 报修表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-26
*/
@Mapper(uses = {MyMapper.class})
public interface RepairConvert {

    RepairConvert INSTANCE = Mappers.getMapper(RepairConvert.class);
    @Mapping(target = "employeeIds",source = "employeeIds",qualifiedByName = "convertToString")
    RepairEntity convert(RepairVO vo);
    @Mapping(target = "employeeIds",source = "employeeIds",qualifiedByName = "convertToArray")
    RepairVO convert(RepairEntity entity);
    @Mapping(target = "employeeIds",source = "employeeIds",qualifiedByName = "convertToArray")
    List<RepairVO> convertList(List<RepairEntity> list);



}
