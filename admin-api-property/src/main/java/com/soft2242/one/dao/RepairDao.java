package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.RepairEntity;
import com.soft2242.one.vo.NoticeVO;
import com.soft2242.one.vo.RepairVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 报修表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-26
*/
@Mapper
public interface RepairDao extends BaseDao<RepairEntity> {
    List<RepairVO> getList(Map<String, Object> map);
}
