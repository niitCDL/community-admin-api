package com.soft2242.one.dao;


import com.soft2242.one.entity.Activity;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
* 社区活动
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface ActivityDao extends BaseDao<Activity> {
	
}