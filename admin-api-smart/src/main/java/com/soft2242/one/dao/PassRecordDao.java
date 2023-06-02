package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PassRecordEntity;
import com.soft2242.one.query.PassRecordQuery;
import com.soft2242.one.vo.PassRecordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 通行记录
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface PassRecordDao extends BaseDao<PassRecordEntity> {

    List<PassRecordVO> selectPageByQuery(PassRecordQuery query);
}