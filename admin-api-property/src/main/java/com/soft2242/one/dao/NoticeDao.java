package com.soft2242.one.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.NoticeEntity;
import com.soft2242.one.query.NoticeQuery;
import com.soft2242.one.vo.NoticeVO;
import com.soft2242.one.vo.RepairVO;
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
public interface NoticeDao extends BaseDao<NoticeEntity> {
    List<NoticeVO> getList(Map<String, Object> map);
}
