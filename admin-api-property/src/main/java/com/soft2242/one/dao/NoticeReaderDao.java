package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.NoticeReaderEntity;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/24 9:11
 */
@Mapper
public interface NoticeReaderDao extends BaseDao<NoticeReaderEntity> {

    List<NoticeReaderEntity> getList(Map<String, Object> params);
}
