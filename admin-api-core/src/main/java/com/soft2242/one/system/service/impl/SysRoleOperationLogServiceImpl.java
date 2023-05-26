package com.soft2242.one.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import com.soft2242.one.system.convert.SysRoleOperationLogConvert;
import com.soft2242.one.system.entity.SysRoleOperationLogEntity;
import com.soft2242.one.system.query.SysRoleOperationLogQuery;
import com.soft2242.one.system.vo.SysRoleOperationLogVO;
import com.soft2242.one.system.dao.SysRoleOperationLogDao;
import com.soft2242.one.system.service.SysRoleOperationLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色操作记录表
 *
 * @author OM1GA soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class SysRoleOperationLogServiceImpl extends BaseServiceImpl<SysRoleOperationLogDao, SysRoleOperationLogEntity> implements SysRoleOperationLogService {

    @Override
    public PageResult<SysRoleOperationLogVO> page(SysRoleOperationLogQuery query) {
        IPage<SysRoleOperationLogEntity> cusPage = baseMapper.getCusPage(getPage(query), getWrapper(query));
        return new PageResult<>(SysRoleOperationLogConvert.INSTANCE.convertList(cusPage.getRecords()), cusPage.getTotal());
    }

    private LambdaQueryWrapper<SysRoleOperationLogEntity> getWrapper(SysRoleOperationLogQuery query){
        LambdaQueryWrapper<SysRoleOperationLogEntity> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public void save(SysRoleOperationLogVO vo) {
        SysRoleOperationLogEntity entity = SysRoleOperationLogConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(SysRoleOperationLogVO vo) {
        SysRoleOperationLogEntity entity = SysRoleOperationLogConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}