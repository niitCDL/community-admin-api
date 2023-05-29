package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.DoorConvert;
import com.soft2242.one.dao.DoorDao;
import com.soft2242.one.entity.DoorEntity;
import com.soft2242.one.query.DoorQuery;
import com.soft2242.one.service.DoorService;
import com.soft2242.one.vo.DoorReviewVO;
import com.soft2242.one.vo.DoorVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 门禁管理
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
@Service
@AllArgsConstructor
public class DoorServiceImpl extends BaseServiceImpl<DoorDao, DoorEntity> implements DoorService {

    @Override
    public PageResult<DoorVO> page(DoorQuery query) {
        IPage<DoorEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(baseMapper.selectPageByQuery(query), page.getTotal());
    }

    @Override
    public void save(DoorVO vo) {
        DoorEntity entity = DoorConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(DoorVO vo) {
        DoorEntity entity = DoorConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public PageResult<DoorReviewVO> getDoorReviewPage(DoorQuery query) {
        IPage<DoorEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(baseMapper.selectReviewByQuery(query), page.getTotal());
    }

    @Override
    public void changeSetting(DoorReviewVO vo) {
        DoorEntity entity = DoorConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    private LambdaQueryWrapper<DoorEntity> getWrapper(DoorQuery query){
        LambdaQueryWrapper<DoorEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(query.getId() != null, DoorEntity::getId, query.getId());
        wrapper.eq(query.getDeviceId() != null, DoorEntity::getDeviceId, query.getDeviceId());
        wrapper.like(StringUtils.isNotEmpty(query.getDoorName()), DoorEntity::getDoorName, query.getDoorName());
        wrapper.eq(query.getCommunityId() != null, DoorEntity::getCommunityId, query.getCommunityId());
        return wrapper;
    }
}