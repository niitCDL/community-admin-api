package com.soft2242.one.sms.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.soft2242.one.sms.entity.SmsLogEntity;
import com.soft2242.one.sms.vo.SmsLogVO;

import java.util.List;

/**
 * 短信日志
 *
 * @author moqi
 */
@Mapper
public interface SmsLogConvert {
    SmsLogConvert INSTANCE = Mappers.getMapper(SmsLogConvert.class);

    SmsLogVO convert(SmsLogEntity entity);

    List<SmsLogVO> convertList(List<SmsLogEntity> list);

}