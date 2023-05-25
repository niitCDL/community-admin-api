package com.soft2242.one.system.dao;

import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysDictDataEntity;
import com.soft2242.one.system.vo.SysDictVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 字典数据
 *
 * @author mqxu
 */
@Mapper
public interface SysDictDataDao extends BaseDao<SysDictDataEntity> {

    @Select("${sql}")
    List<SysDictVO.DictData> getListForSql(@Param("sql") String sql);
}
