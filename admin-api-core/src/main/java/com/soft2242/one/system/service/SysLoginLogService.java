package com.soft2242.one.system.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.security.user.UserDetail;
import com.soft2242.one.system.entity.SysLoginLogEntity;
import com.soft2242.one.system.query.SysLoginLogQuery;
import com.soft2242.one.system.query.SysRoleOperationLogQuery;
import com.soft2242.one.system.vo.SysLoginLogExcelVO;
import com.soft2242.one.system.vo.SysRoleOperationLogVO;

public interface SysLoginLogService {
    void record(UserDetail user);

    void export();

    PageResult<SysLoginLogExcelVO> page(SysLoginLogQuery query);
}
