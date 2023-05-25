package com.soft2242.one.convert;

import com.soft2242.one.query.NoticeQuery;
import com.soft2242.one.query.NoticeReaderQuery;
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
public interface NoticeQueryConvert {
    NoticeQueryConvert INSTANCE = Mappers.getMapper(NoticeQueryConvert.class);

    NoticeQuery convert(NoticeReaderQuery vo);

}
