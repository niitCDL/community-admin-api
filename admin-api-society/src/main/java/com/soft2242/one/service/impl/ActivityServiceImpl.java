package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.ActivityConvert;
import com.soft2242.one.dao.ActivityDao;
import com.soft2242.one.entity.Activity;
import com.soft2242.one.query.ActivityQuery;
import com.soft2242.one.service.ActivityService;
import com.soft2242.one.service.ActivityTypeService;
import com.soft2242.one.service.ICommunityService;
import com.soft2242.one.vo.ActivityVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 社区活动
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class ActivityServiceImpl extends BaseServiceImpl<ActivityDao, Activity> implements ActivityService {
    private final ICommunityService communityService;
    private final ActivityTypeService activityTypeService;

    @Override
    public PageResult<ActivityVO> page(ActivityQuery query) {
        IPage<Activity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<ActivityVO> activityVOS = ActivityConvert.INSTANCE.convertList(page.getRecords());
        activityVOS.forEach(o -> {
            o.setCommunityName(communityService.getById(o.getCommunityId()).getCommunityName());
            o.setActivityType(activityTypeService.getById(o.getTypeId()).getName());
        });
        return new PageResult<>(activityVOS, page.getTotal());
    }

    private LambdaQueryWrapper<Activity> getWrapper(ActivityQuery query) {
        LambdaQueryWrapper<Activity> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public void save(ActivityVO vo) {
        Activity entity = ActivityConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(ActivityVO vo) {
        Activity entity = ActivityConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}