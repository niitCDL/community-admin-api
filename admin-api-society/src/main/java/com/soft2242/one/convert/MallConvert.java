package com.soft2242.one.convert;

import com.soft2242.one.entity.Mall;
import com.soft2242.one.vo.MallVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Author: James
 * Date: 2023/5/25 14:47
 * Describe:
 */

@Mapper
public interface MallConvert {
    MallConvert INSTANCE = Mappers.getMapper(MallConvert.class);

    Mall convert(MallVO vo);

    MallVO convert(Mall entity);

    List<MallVO> convertList(List<Mall> list);



}
