package com.soft2242.one.system.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.vo.SysDepartmentVO;
import com.soft2242.one.system.query.SysDepartmentQuery;
import com.soft2242.one.system.entity.SysDepartmentEntity;

import java.util.List;

/**
 * 部门
 *
 * @author OM1GA soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface SysDepartmentService extends BaseService<SysDepartmentEntity> {

    List<SysDepartmentVO> getList();

    void save(SysDepartmentVO vo);

    void update(SysDepartmentVO vo);

    void delete(Long id);

    List<Long> getSubOrgIdList(Long id);
}