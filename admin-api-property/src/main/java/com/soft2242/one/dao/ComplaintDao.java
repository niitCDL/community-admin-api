package com.soft2242.one.dao;


import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.ComplaintEntity;
import com.soft2242.one.vo.ComplaintVO;
import com.soft2242.one.vo.RepairVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 投诉
*
* @author xuelong
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface ComplaintDao extends BaseDao<ComplaintEntity> {
    List<ComplaintVO> getList(Map<String, Object> map);
}
