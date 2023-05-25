package com.soft2242.one.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import com.soft2242.one.system.convert.SysAdminDepartmentConvert;
import com.soft2242.one.system.entity.SysAdminDepartmentEntity;
import com.soft2242.one.system.query.SysAdminDepartmentQuery;
import com.soft2242.one.system.vo.SysAdminDepartmentVO;
import com.soft2242.one.system.dao.SysAdminDepartmentDao;
import com.soft2242.one.system.service.SysAdminDepartmentService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.support.PageableExecutionUtils.getPage;

/**
 * 管理员部门关联表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class SysAdminDepartmentServiceImpl extends BaseServiceImpl<SysAdminDepartmentDao, SysAdminDepartmentEntity> implements SysAdminDepartmentService {


    @Override
    public List<Long> getUidListByDid(Long Did) {
        return baseMapper.getAdminIdList(Did);
    }

    @Override
    public void save(SysAdminDepartmentVO vo) {
        SysAdminDepartmentEntity entity = SysAdminDepartmentConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysAdminDepartmentVO vo) {
        SysAdminDepartmentEntity entity = SysAdminDepartmentConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}