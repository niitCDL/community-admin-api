package com.soft2242.one.system.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.vo.SysRoleOperationLogVO;
import com.soft2242.one.system.query.SysRoleOperationLogQuery;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;

import java.util.List;

/**
 * 角色操作记录表
 *
 * @author OM1GA soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface SysRoleOperationLogService extends BaseService<SysRoleOperationLogEntity> {

    PageResult<SysRoleOperationLogVO> page(SysRoleOperationLogQuery query);

    void save(SysRoleOperationLogVO vo);

    void update(SysRoleOperationLogVO vo);

    void delete(List<Long> idList);
}