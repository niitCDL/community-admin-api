package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.Building;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

/**
 * @ClassName BuildingDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/26 08:08
 */
@Mapper
public interface BuildingDao extends BaseDao<Building> {
    List<Building> getList(Map<String,Object> params);
}
