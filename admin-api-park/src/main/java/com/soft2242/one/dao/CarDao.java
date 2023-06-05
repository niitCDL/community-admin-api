package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.Car;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.vo.CarVO;
import com.soft2242.one.vo.CarportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CarDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/29 19:21
 */
@Mapper
public interface CarDao extends BaseDao<Car> {

    List<CarVO> getList(Map<String,Object> params);
    CarVO getInfo(Long id);
    void updatePhone(@Param("id") Long id,@Param("phone") String phone);
}
