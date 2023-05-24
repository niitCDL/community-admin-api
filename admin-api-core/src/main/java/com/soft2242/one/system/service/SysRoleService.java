package com.soft2242.one.system.service;


import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.entity.SysRoleEntity;
import com.soft2242.one.system.query.SysRoleQuery;
import com.soft2242.one.system.vo.SysRoleDataScopeVO;
import com.soft2242.one.system.vo.SysRoleVO;

import java.util.List;

/**
 * 角色
 *
 * @author moqi
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

    PageResult<SysRoleVO> page(SysRoleQuery query);

    List<SysRoleVO> getList(SysRoleQuery query);

    void save(SysRoleVO vo);

    void update(SysRoleVO vo);

    void dataScope(SysRoleDataScopeVO vo);

    void delete(List<Long> idList);
}
