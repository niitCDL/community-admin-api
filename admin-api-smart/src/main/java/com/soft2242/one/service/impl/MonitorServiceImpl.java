package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.MonitorConvert;
import com.soft2242.one.dao.MonitorDao;
import com.soft2242.one.entity.MonitorEntity;
import com.soft2242.one.query.MonitorQuery;
import com.soft2242.one.service.MonitorService;
import com.soft2242.one.vo.MonitorVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 监控表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
@Service
@AllArgsConstructor
public class MonitorServiceImpl extends BaseServiceImpl<MonitorDao, MonitorEntity> implements MonitorService {

    @Override
    public PageResult<MonitorVO> page(MonitorQuery query) {
        IPage<MonitorEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(baseMapper.selectPageByQuery(query), page.getTotal());
    }

    private LambdaQueryWrapper<MonitorEntity> getWrapper(MonitorQuery query){
        LambdaQueryWrapper<MonitorEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(query.getDeviceId() != null, MonitorEntity::getDeviceId, query.getDeviceId());
        wrapper.eq(query.getCommunityId() != null, MonitorEntity::getCommunityId, query.getCommunityId());
        wrapper.like(StringUtils.isNotEmpty(query.getMonitorName()), MonitorEntity::getMonitorName, query.getMonitorName());
        wrapper.eq(query.getStatus() != null, MonitorEntity::getStatus, query.getStatus());
        wrapper.eq(query.getMonitorType() != null, MonitorEntity::getMonitorType, query.getMonitorType());
        return wrapper;
    }

    @Override
    public void save(MonitorVO vo) {
        MonitorEntity entity = MonitorConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(MonitorVO vo) {
        MonitorEntity entity = MonitorConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}