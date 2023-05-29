package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.vo.CarportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CarportDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 15:18
 */
@Mapper
public interface CarportDao extends BaseDao<Carport> {

    List<CarportVO> getList(Map<String,Object> params);
}
