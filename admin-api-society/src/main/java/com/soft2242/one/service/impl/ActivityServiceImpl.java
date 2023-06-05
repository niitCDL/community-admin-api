package com.soft2242.one.service.impl;

import com.alibaba.excel.annotation.format.DateTimeFormat;
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
import org.bouncycastle.crypto.engines.CramerShoupCiphertext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    private String changeForm(LocalDateTime create, LocalDateTime end) {
        return create.toString().substring(0, 10) + "~" + end.toString().substring(0, 10);
    }

    //    修改查询条件： 根据活动时间，活动名称
    @Override
    public PageResult<ActivityVO> page(ActivityQuery query) {
        LambdaQueryWrapper<Activity> wrapper = getWrapper(query);
        System.out.println(query);
//        根据活动名查询
        if (query.getActivityName() != null)
            if (!query.getActivityName().isBlank() && !query.getActivityName().isEmpty())
                wrapper.eq(Activity::getActivityName, query.getActivityName());
//        时间是否为空
        if (!(query.getCreateTime() == null && query.getEndTime() == null)) {
//            格式
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println(query.getCreateTime().toString());
            LocalDateTime createTime = LocalDateTime.parse(query.getCreateTime(),dateTimeFormatter );
            LocalDateTime endTime = LocalDateTime.parse(query.getEndTime(),dateTimeFormatter);
            System.out.println(createTime);
            System.out.println(endTime);

            wrapper.or().between(Activity::getCreateTime, createTime, endTime)
                    .and(a -> a.between(Activity::getEndTime, createTime, endTime));
        } else {
//            清空
            query.setCreateTime(null);
            query.setEndTime(null);
        }
        IPage<Activity> page = baseMapper.selectPage(getPage(query), wrapper);
        List<ActivityVO> activityVOS = ActivityConvert.INSTANCE.convertList(page.getRecords());
        PageResult<ActivityVO> result;
        try {
            activityVOS.forEach(o -> {
                o.setCommunityName(communityService.getById(o.getCommunityId()).getCommunityName());
                o.setActivityType(activityTypeService.getById(o.getTypeId()).getName());
                o.setATime(changeForm(o.getCreateTime(),o.getEndTime()));
            });
            result = new PageResult<>(activityVOS, page.getTotal());
        } catch (Exception e) {
            result = new PageResult<>(new ArrayList<>(), page.getTotal());
            throw new RuntimeException(e);
        }
        return result;
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

    @Override
    public void status(Integer id) {
        Activity activity = baseMapper.selectById(id);
        Integer status = activity.getStatus();
        if (status == 1) {
            activity.setStatus(0);
            System.out.println(activity);
            baseMapper.updateById(activity);
        } else if (status == 0) {
            activity.setStatus(1);
            System.out.println(activity);
            baseMapper.updateById(activity);
        }
    }

    @Override
    public List<ActivityVO> getList() {
        List<Activity> activities = baseMapper.selectList(getWrapper(new ActivityQuery()));
        return ActivityConvert.INSTANCE.convertList(activities);
    }

}