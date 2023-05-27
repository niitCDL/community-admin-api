package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.House;
import com.soft2242.one.vo.HouseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName HouseDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/27 14:50
 */
@Mapper
public interface HouseDao extends BaseDao<House> {
    List<HouseVO> getList(Map<String,Object> params);
}
