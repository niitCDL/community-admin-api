package com.soft2242.one.system.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* 角色操作记录表
*
* @author OM1GA soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface SysRoleOperationLogDao extends BaseDao<SysRoleOperationLogEntity> {
    String querySql = "select a.* , (b.name)operationObjectName from sys_role_operation_log a LEFT JOIN sys_role b ON a.operation_object = b.id";
    String wrapperSql = "select * from ("+querySql+")AS q ${ew.customSqlSegment}";

    @Select(wrapperSql)
    IPage<SysRoleOperationLogEntity> getCusPage(IPage page,@Param("ew") Wrapper queryWrapper);
}