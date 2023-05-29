package com.soft2242.one.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.Building;
import com.soft2242.one.vo.BuildingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


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
    List<BuildingVO> getList(Map<String,Object> params);

}
