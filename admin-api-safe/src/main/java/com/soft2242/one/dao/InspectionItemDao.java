package com.soft2242.one.dao;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.InspectionItemEntity;
import com.soft2242.one.vo.InspectionItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
* 巡检项目
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface InspectionItemDao extends BaseDao<InspectionItemEntity> {
    List<InspectionItemVO> getInspectionList(Map<String,Object> params);
}