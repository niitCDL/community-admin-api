package com.soft2242.one.convert;

import com.soft2242.one.entity.Visitor;
import com.soft2242.one.vo.VisitorVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Author: James
 * Date: 2023/5/25 14:51
 * Describe:
 */

@Mapper

public interface VisitorConvert {
    VisitorConvert INSTANCE = Mappers.getMapper(VisitorConvert.class);

    Visitor convert(VisitorVO vo);
    VisitorVO convert(Visitor entity);

    List<VisitorVO> convertList(List<Visitor> list);


}
