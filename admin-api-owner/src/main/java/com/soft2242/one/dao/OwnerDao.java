package com.soft2242.one.dao;


import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.OwnerEntity;
import com.soft2242.one.query.OwnerQuery;
import com.soft2242.one.vo.OwnerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 业主表
*
* @author lsc lsc666@qq.com
* @since 1.0.0 2023-05-28
*/
@Mapper
public interface OwnerDao extends BaseDao<OwnerEntity> {
    int findOwnerRecordByOQ(OwnerQuery ownerQuery);
    List<OwnerVO> findOwnerOQ(OwnerQuery ownerQuery);
    OwnerVO findOwnerInfo(Long id);
}