package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.ActivityTypeConvert;
import com.soft2242.one.dao.ActivityTypeDao;
import com.soft2242.one.entity.ActivityType;

import com.soft2242.one.query.ActivityTypeQuery;
import com.soft2242.one.service.ActivityTypeService;
import com.soft2242.one.vo.ActivityTypeVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 活动分类
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class ActivityTypeServiceImpl extends BaseServiceImpl<ActivityTypeDao, ActivityType> implements ActivityTypeService {

    @Override
    public PageResult<ActivityTypeVO> page(ActivityTypeQuery query) {
        IPage<ActivityType> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(ActivityTypeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<ActivityType> getWrapper(ActivityTypeQuery query) {
        LambdaQueryWrapper<ActivityType> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public void save(ActivityTypeVO vo) {
        ActivityType entity = ActivityTypeConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(ActivityTypeVO vo) {
        ActivityType entity = ActivityTypeConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}