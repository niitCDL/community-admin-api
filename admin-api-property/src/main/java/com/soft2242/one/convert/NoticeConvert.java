package com.soft2242.one.convert;

import com.soft2242.one.entity.NoticeEntity;
import com.soft2242.one.vo.NoticeVO;
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
public interface NoticeConvert {
    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    NoticeEntity convert(NoticeVO vo);

    NoticeVO convert(NoticeEntity entity);

    List<NoticeVO> convertList(List<NoticeEntity> list);
}
