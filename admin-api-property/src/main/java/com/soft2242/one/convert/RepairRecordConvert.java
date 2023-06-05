package com.soft2242.one.convert;


import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.vo.RepairRecordVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 报修处理表
*
* @author xuelong
* @since 1.0.0 2023-06-04
*/
@Mapper
public interface RepairRecordConvert {
    RepairRecordConvert INSTANCE = Mappers.getMapper(RepairRecordConvert.class);

    RepairRecordEntity convert(RepairRecordVO vo);

    RepairRecordVO convert(RepairRecordEntity entity);

    List<RepairRecordVO> convertList(List<RepairRecordEntity> list);

}
