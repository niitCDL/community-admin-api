package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.Community;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CommunityDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/25 14:26
 */
@Mapper
public interface CommunityDao extends BaseDao<Community> {
    List<Community> getList(Map<String,Object> params);
}
