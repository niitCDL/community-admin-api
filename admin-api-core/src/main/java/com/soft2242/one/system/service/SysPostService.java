package com.soft2242.one.system.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.system.entity.SysPostEntity;
import com.soft2242.one.system.entity.SysUserEntity;
import com.soft2242.one.system.query.SysPostQuery;
import com.soft2242.one.system.vo.SysDepartmentVO;
import com.soft2242.one.system.vo.SysPostVO;
import com.soft2242.one.system.vo.SysUserVO;

import java.util.List;
import java.util.Map;

/**
 * 部门
 *
 * @author OM1GA soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface SysPostService extends BaseService<SysPostEntity> {

    PageResult<SysPostVO> page(SysPostQuery query);

    List<SysPostVO> getList();

    void save(SysPostVO vo);

    void update(SysPostVO vo);

    void delete(List<Long> idList);
}