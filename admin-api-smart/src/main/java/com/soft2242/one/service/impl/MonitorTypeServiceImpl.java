package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.MonitorTypeConvert;
import com.soft2242.one.dao.MonitorTypeDao;
import com.soft2242.one.entity.MonitorTypeEntity;
import com.soft2242.one.query.MonitorTypeQuery;
import com.soft2242.one.service.MonitorTypeService;
import com.soft2242.one.vo.MonitorTypeVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 监控分组
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
@Service
@AllArgsConstructor
public class MonitorTypeServiceImpl extends BaseServiceImpl<MonitorTypeDao, MonitorTypeEntity> implements MonitorTypeService {

    @Override
    public PageResult<MonitorTypeVO> page(MonitorTypeQuery query) {
        IPage<MonitorTypeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(MonitorTypeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<MonitorTypeEntity> getWrapper(MonitorTypeQuery query){
        LambdaQueryWrapper<MonitorTypeEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.isNotEmpty(query.getType()), MonitorTypeEntity::getType, query.getType());
        wrapper.like(StringUtils.isNotEmpty(query.getDes()), MonitorTypeEntity::getDes, query.getDes());
        return wrapper;
    }

    @Override
    public void save(MonitorTypeVO vo) {
        MonitorTypeEntity entity = MonitorTypeConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(MonitorTypeVO vo) {
        MonitorTypeEntity entity = MonitorTypeConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }
}