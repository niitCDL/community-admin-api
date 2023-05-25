package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.PatrolPointsConvert;
import com.soft2242.one.dao.PatrolPointsDao;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.query.PatrolPointsQuery;
import com.soft2242.one.service.PatrolPointsService;
import com.soft2242.one.vo.PatrolPointsVO;
import lombok.AllArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.support.PageableExecutionUtils.getPage;

/**
 * 巡更点表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class PatrolPointsServiceImpl extends BaseServiceImpl<PatrolPointsDao, PatrolPointsEntity> implements PatrolPointsService {

    @Override
    public PageResult<PatrolPointsVO> page(PatrolPointsQuery query) {
        IPage<PatrolPointsEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(PatrolPointsConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<PatrolPointsEntity> getWrapper(PatrolPointsQuery query){
        LambdaQueryWrapper<PatrolPointsEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNotEmpty(String.valueOf(query.getCommunityId())), PatrolPointsEntity::getId, query.getCommunityId());
        return wrapper;
    }

    @Override
    public void save(PatrolPointsVO vo) {
        PatrolPointsEntity entity = PatrolPointsConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(PatrolPointsVO vo) {
        PatrolPointsEntity entity = PatrolPointsConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}