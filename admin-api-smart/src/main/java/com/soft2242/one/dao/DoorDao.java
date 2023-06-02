package com.soft2242.one.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.DoorEntity;
import com.soft2242.one.query.DoorQuery;
import com.soft2242.one.vo.DoorSettingVO;
import com.soft2242.one.vo.DoorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 门禁管理
*
* @author Flobby 
* @since 1.0.0 2023-05-29
*/
@Mapper
public interface DoorDao extends BaseDao<DoorEntity> {

    List<DoorVO> selectPageByQuery(DoorQuery query);

    List<DoorSettingVO> selectSettingByQuery(DoorQuery query);
}