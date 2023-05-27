package com.soft2242.one.convert;

import com.soft2242.one.entity.Order;
import com.soft2242.one.vo.OrderExcelVO;
import com.soft2242.one.vo.OrderVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Author: James
 * Date: 2023/5/25 14:49
 * Describe:
 */

@Mapper

public interface OrderConvert {
    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);

    Order convert(OrderVO vo);

    OrderVO convert(Order entity);

    List<OrderVO> convertList(List<Order> list);

    List<OrderExcelVO> convertList2(List<Order> list);

    List<Order> convertListEntity(List<OrderExcelVO> list);


}
