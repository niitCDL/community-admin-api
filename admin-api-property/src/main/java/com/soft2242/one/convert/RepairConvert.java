package com.soft2242.one.convert;

import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.vo.RepairVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 报修表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface RepairConvert {
    RepairConvert INSTANCE = Mappers.getMapper(RepairConvert.class);

    RepairEntity convert(RepairVO vo);

    RepairVO convert(RepairEntity entity);

    List<RepairVO> convertList(List<RepairEntity> list);

}
