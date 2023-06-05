package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.ActivityTypeConvert;
import com.soft2242.one.dao.ActivityTypeDao;
import com.soft2242.one.entity.Activity;
import com.soft2242.one.entity.ActivityType;

import com.soft2242.one.query.ActivityTypeQuery;
import com.soft2242.one.service.ActivityTypeService;
import com.soft2242.one.service.ICommunityService;
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
    private final ICommunityService communityService;


    @Override
    public PageResult<ActivityTypeVO> page(ActivityTypeQuery query) {
        LambdaQueryWrapper<ActivityType> wrapper = getWrapper(query);
        System.out.println(query);
        if (query.getTypeName() != null)
            if (!query.getTypeName().isBlank() && !query.getTypeName().isEmpty())
                wrapper.eq(ActivityType::getName, query.getTypeName());

        IPage<ActivityType> page = baseMapper.selectPage(getPage(query),wrapper);
        List<ActivityTypeVO> activityTypeVOS = ActivityTypeConvert.INSTANCE.convertList(page.getRecords());
//        配置小区名字
        activityTypeVOS.forEach(a -> a.setCommunityName(communityService.getById(a.getCommunityId()).getCommunityName()));
        return new PageResult<>(activityTypeVOS, page.getTotal());
    }

    @Override
    public PageResult<ActivityTypeVO> page2(ActivityTypeQuery query) {
        IPage<ActivityType> page = baseMapper.selectPage(getPage(query), getWrapper2(query));
        List<ActivityTypeVO> activityTypeVOS = ActivityTypeConvert.INSTANCE.convertList(page.getRecords());
//        配置小区名字
        activityTypeVOS.forEach(a -> a.setCommunityName(communityService.getById(a.getCommunityId()).getCommunityName()));
        return new PageResult<>(activityTypeVOS, page.getTotal());
    }

    private LambdaQueryWrapper<ActivityType> getWrapper2(ActivityTypeQuery query) {
        LambdaQueryWrapper<ActivityType> wrapper = Wrappers.lambdaQuery();
//        查询没有被删除的
//        eq(ActivityType::getStatus, 0)
        wrapper.eq(ActivityType::getDeleted, 0);
        return wrapper;
    }

    private LambdaQueryWrapper<ActivityType> getWrapper(ActivityTypeQuery query) {
//        无条件查询
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

    @Override
    public void status(Integer id) {
        ActivityType activityType = baseMapper.selectById(id);
        System.out.println(activityType);
        Integer status = activityType.getStatus();
        if (status == 1) {
            activityType.setStatus(0);
            System.out.println(activityType);

            baseMapper.updateById(activityType);
        } else if (status == 0) {
            activityType.setStatus(1);
            System.out.println(activityType);

            baseMapper.updateById(activityType);
        }

    }

    @Override
    public List<ActivityTypeVO> getList() {
        List<ActivityType> activityTypes = baseMapper.selectList(getWrapper(new ActivityTypeQuery()));
        return ActivityTypeConvert.INSTANCE.convertList(activityTypes);
    }

}