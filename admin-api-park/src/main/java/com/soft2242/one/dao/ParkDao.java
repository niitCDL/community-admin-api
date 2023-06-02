package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.Park;
import com.soft2242.one.vo.ParkVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 停车场表
*
* @author Dr.King whfplus7@163.com
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface ParkDao extends BaseDao<Park> {
    List<ParkVO> getList(Map<String,Object> params);
	
}