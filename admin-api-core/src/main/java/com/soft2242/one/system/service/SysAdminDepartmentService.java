package com.soft2242.one.system.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.vo.SysAdminDepartmentVO;
import com.soft2242.one.system.query.SysAdminDepartmentQuery;
import com.soft2242.one.system.entity.SysAdminDepartmentEntity;

import java.util.List;

/**
 * 管理员部门关联表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface SysAdminDepartmentService extends BaseService<SysAdminDepartmentEntity> {

    List<Long> getUidListByDid(Long Did);

    void save(SysAdminDepartmentVO vo);

    void update(SysAdminDepartmentVO vo);

    void delete(List<Long> idList);
}