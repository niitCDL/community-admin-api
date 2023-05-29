package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.Mall;
import com.soft2242.one.vo.MallVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MallDao
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/28 19:34
 */
@Mapper
public interface MallDao extends BaseDao<Mall> {
    List<MallVO> getList(Map<String,Object> params);
}
