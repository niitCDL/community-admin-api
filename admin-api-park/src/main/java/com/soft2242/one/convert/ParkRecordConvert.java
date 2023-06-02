package com.soft2242.one.convert;

import com.soft2242.one.entity.Park;
import com.soft2242.one.entity.ParkRecord;
import com.soft2242.one.vo.ParkRecordVO;
import com.soft2242.one.vo.ParkVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName ParkRecordConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/30 08:54
 */
@Mapper
public interface ParkRecordConvert {
    ParkRecordConvert INSTANCE = Mappers.getMapper(ParkRecordConvert.class);

    ParkRecord convert(ParkRecordVO vo);

    ParkRecordVO convert(ParkRecord entity);

    List<ParkRecordVO> convertList(List<ParkRecord> list);

    List<ParkRecord> convertListEntity(List<ParkRecordVO> list);
}
