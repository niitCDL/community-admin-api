package com.soft2242.one.convert;

import com.soft2242.one.entity.Building;
import com.soft2242.one.entity.Mall;
import com.soft2242.one.vo.BuildingVO;
import com.soft2242.one.vo.MallVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName MallConvert
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/28 19:41
 */
@Mapper
public interface MallConvert {
    MallConvert INSTANCE = Mappers.getMapper(MallConvert.class);
    MallVO convert(Mall entity);

    Mall convert(MallVO vo);

    List<MallVO> convertList(List<Mall> list);

    List<Mall> convertListEntity(List<MallVO> list);
}
