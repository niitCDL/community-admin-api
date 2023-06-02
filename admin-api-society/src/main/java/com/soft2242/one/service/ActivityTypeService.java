package com.soft2242.one.service;


import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.ActivityType;

import com.soft2242.one.query.ActivityTypeQuery;
import com.soft2242.one.vo.ActivityTypeVO;

import java.util.List;

/**
 * 活动分类
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface ActivityTypeService extends BaseService<ActivityType> {

    PageResult<ActivityTypeVO> page(ActivityTypeQuery query);
    PageResult<ActivityTypeVO> page2(ActivityTypeQuery query);

    void save(ActivityTypeVO vo);

    void update(ActivityTypeVO vo);

    void delete(List<Long> idList);

    void status(Integer id);

    List<ActivityTypeVO> getList();
}