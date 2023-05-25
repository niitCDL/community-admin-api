package com.soft2242.one.convert;

import com.soft2242.one.entity.NoticeReaderEntity;
import com.soft2242.one.vo.NoticeReaderVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/24 14:29
 */
@Mapper
public interface NoticeReaderConvert {
    NoticeReaderConvert INSTANCE = Mappers.getMapper(NoticeReaderConvert.class);

    NoticeReaderEntity convert(NoticeReaderVO vo);

    NoticeReaderVO convert(NoticeReaderEntity entity);

    List<NoticeReaderVO> convertList(List<NoticeReaderEntity> list);
}
