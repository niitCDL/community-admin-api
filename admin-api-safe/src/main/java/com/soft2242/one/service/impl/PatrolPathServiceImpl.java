package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.PatrolPathConvert;
import com.soft2242.one.dao.PatrolPathDao;
import com.soft2242.one.entity.PatrolPathEntity;
import com.soft2242.one.query.PatrolPathQuery;
import com.soft2242.one.service.PatrolPathService;
import com.soft2242.one.vo.PatrolPathVO;
import lombok.AllArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 巡更路线表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class PatrolPathServiceImpl extends BaseServiceImpl<PatrolPathDao, PatrolPathEntity> implements PatrolPathService {

    @Override
    public PageResult<PatrolPathVO> page(PatrolPathQuery query) {
        IPage<PatrolPathEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(PatrolPathConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<PatrolPathEntity> getWrapper(PatrolPathQuery query){
        LambdaQueryWrapper<PatrolPathEntity> wrapper = Wrappers.lambdaQuery();
//        wrapper.eq(StringUtils.isNotEmpty(query.getCommunityId()), PatrolPathEntity::getCommunityId, query.getCommunityId());
        wrapper.eq(StringUtils.isNotEmpty(query.getCommunityId().toString()), PatrolPathEntity::getCommunityId, query.getCommunityId());
        return wrapper;
    }

    @Override
    public void save(PatrolPathVO vo) {
        PatrolPathEntity entity = PatrolPathConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(PatrolPathVO vo) {
        PatrolPathEntity entity = PatrolPathConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}