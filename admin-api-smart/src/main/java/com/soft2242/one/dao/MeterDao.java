package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.MeterEntity;
import com.soft2242.one.query.MeterQuery;
import com.soft2242.one.vo.MeterVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 仪表表
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface MeterDao extends BaseDao<MeterEntity> {

    List<MeterVO> selectPageByQuery(MeterQuery query);
}