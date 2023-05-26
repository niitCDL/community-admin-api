package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.MonitorEntity;
import com.soft2242.one.query.MonitorQuery;
import com.soft2242.one.vo.MonitorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 监控表
*
* @author Flobby 
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface MonitorDao extends BaseDao<MonitorEntity> {

    List<MonitorVO> selectPageByQuery(MonitorQuery query);
}