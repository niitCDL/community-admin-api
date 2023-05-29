package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PassReviewEntity;
import com.soft2242.one.query.PassReviewQuery;
import com.soft2242.one.vo.PassReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 门禁审核
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface PassReviewDao extends BaseDao<PassReviewEntity> {

    List<PassReviewVO> selectPageByQuery(PassReviewQuery query);
}