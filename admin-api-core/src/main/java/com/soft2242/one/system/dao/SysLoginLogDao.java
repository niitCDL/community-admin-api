package com.soft2242.one.system.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysLoginLogEntity;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import com.soft2242.one.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 系统用户
 *
 * @author mqxu
 */
@Mapper
public interface SysLoginLogDao extends BaseDao<SysLoginLogEntity> {

    String querySql = "SELECT a.* FROM t_system_operation_log a";
    String wrapperSql = "select * from ("+querySql+")AS q ${ew.customSqlSegment}";

    @Select(wrapperSql)
    IPage<SysLoginLogEntity> getCusPage(IPage page, @Param("ew") Wrapper queryWrapper);
}