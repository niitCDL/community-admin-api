package com.soft2242.one.dao;


import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.vo.RepairRecordVO;
import com.soft2242.one.vo.RepairVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 报修处理表
*
* @author xuelong
* @since 1.0.0 2023-06-04
*/
@Mapper
public interface RepairRecordDao extends BaseDao<RepairRecordEntity> {
    List<RepairRecordVO> getList(Map<String, Object> map);
}
