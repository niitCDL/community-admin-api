package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.convert.PatrolRecordsConvert;
import com.soft2242.one.entity.PatrolRecordsEntity;

import com.soft2242.one.vo.PatrolRecordsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 巡更记录表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface PatrolRecordsDao extends BaseDao<PatrolRecordsEntity> {

    List<PatrolRecordsVO> searchList(Map<String,Object> params);
}