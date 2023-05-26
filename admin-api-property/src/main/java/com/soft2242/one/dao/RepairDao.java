package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.RepairEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 报修表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface RepairDao extends BaseDao<RepairEntity> {

}
