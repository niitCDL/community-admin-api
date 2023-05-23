package com.soft2242.one.sms.convert;

import com.soft2242.one.sms.entity.SmsPlatformEntity;
import com.soft2242.one.sms.sms.config.SmsConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.soft2242.one.sms.vo.SmsPlatformVO;

import java.util.List;

/**
 * 短信平台
 *
 * @author mqxu
 */
@Mapper
public interface SmsPlatformConvert {
    SmsPlatformConvert INSTANCE = Mappers.getMapper(SmsPlatformConvert.class);

    SmsPlatformEntity convert(SmsPlatformVO vo);

    SmsPlatformVO convert(SmsPlatformEntity entity);

    List<SmsPlatformVO> convertList(List<SmsPlatformEntity> list);

    SmsConfig convert2(SmsPlatformEntity entity);

    List<SmsConfig> convertList2(List<SmsPlatformEntity> list);

}