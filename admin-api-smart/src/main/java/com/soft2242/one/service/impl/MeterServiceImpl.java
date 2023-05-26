package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.MeterConvert;
import com.soft2242.one.dao.MeterDao;
import com.soft2242.one.entity.MeterEntity;
import com.soft2242.one.query.MeterQuery;
import com.soft2242.one.service.MeterService;
import com.soft2242.one.vo.MeterVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 仪表表
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-26
 */
@Service
@AllArgsConstructor
public class MeterServiceImpl extends BaseServiceImpl<MeterDao, MeterEntity> implements MeterService {

    @Override
    public PageResult<MeterVO> page(MeterQuery query) {
        IPage<MeterEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(baseMapper.selectPageByQuery(query), page.getTotal());
    }

    private LambdaQueryWrapper<MeterEntity> getWrapper(MeterQuery query){
        LambdaQueryWrapper<MeterEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.isNotEmpty(query.getMeterName()), MeterEntity::getMeterName, query.getMeterName());
        wrapper.eq(query.getCommunityId() != null, MeterEntity::getCommunityId, query.getCommunityId());
        wrapper.eq(query.getMeterType() != null, MeterEntity::getMeterType, query.getMeterType());
        wrapper.eq(query.getOnlineStatus() != null, MeterEntity::getOnlineStatus, query.getOnlineStatus());
        wrapper.eq(query.getGateStatus() != null, MeterEntity::getGateStatus, query.getGateStatus());
        return wrapper;
    }

    @Override
    public void save(MeterVO vo) {
        MeterEntity entity = MeterConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(MeterVO vo) {
        MeterEntity entity = MeterConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}