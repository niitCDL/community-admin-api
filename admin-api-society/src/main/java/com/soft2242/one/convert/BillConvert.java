package com.soft2242.one.convert;

import com.soft2242.one.entity.Bill;
import com.soft2242.one.vo.BillVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Author: James
 * Date: 2023/5/25 14:44
 * Describe:
 */
@Mapper
public interface BillConvert {
    BillConvert  INSTANCE = Mappers.getMapper(BillConvert.class);

    Bill convert(BillVO vo);

    BillVO convert(Bill entity);

    List<BillVO> convertList(List<Bill> list);
}
