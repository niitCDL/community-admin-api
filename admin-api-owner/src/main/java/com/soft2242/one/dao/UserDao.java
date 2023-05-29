package com.soft2242.one.dao;


import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 用户信息表
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
	
}