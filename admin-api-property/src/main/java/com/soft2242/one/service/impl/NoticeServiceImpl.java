package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.constant.Constant;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.NoticeConvert;
import com.soft2242.one.convert.RepairConvert;
import com.soft2242.one.dao.NoticeDao;
import com.soft2242.one.entity.NoticeEntity;
import com.soft2242.one.entity.NoticeEntity;
import com.soft2242.one.query.BuildingQuery;
import com.soft2242.one.query.NoticeQuery;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.service.NoticeService;
import com.soft2242.one.utils.MyUtils;
import com.soft2242.one.vo.NoticeVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/24 9:14
 */
@Service
@AllArgsConstructor
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {

    private final NoticeDao noticeDao;

    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
//        IPage<NoticeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
//        return new PageResult<>(NoticeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
        Map<String, Object> map = null;
        try {
            map = MyUtils.objectToMap(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IPage<NoticeEntity> page = getPage(query);
//        map.put("queryWrapper",page);
        map.put("page", getWrapper(query));
        if (ArrayUtils.isNotEmpty(query.getCreateTime())) {
            Date begin = ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[0] : null;
            Date end = ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[1] : null;
            map.put("createTime", query.getCreateTime());
            map.put("begin", begin);
            map.put("end", end);
        }
        map.put("communityId", MyUtils.convertToString(query.getCommunityId()));
        List<NoticeVO> list = noticeDao.getList(map);

        return new PageResult<>(list, page.getTotal());
    }

//    private Map<String, Object> getParams(NoticeQuery query) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("title",query.getTitle());
//        params.put("noticeId",query.getNoticeId());
//        params.put("content",query.getContent());
//        params.put("adminId",query.getAdminId());
//        System.out.println(convertToString(query.getCommunityId()));
//        params.put("communityId", convertToString(query.getCommunityId()));
//        return params;
//    }


    private LambdaQueryWrapper<NoticeEntity> getWrapper(NoticeQuery query) {
        LambdaQueryWrapper<NoticeEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.isNotEmpty(query.getTitle()), NoticeEntity::getTitle, query.getTitle());
        wrapper.in(ArrayUtils.isNotEmpty(query.getCommunityId()), NoticeEntity::getCommunityId, query.getCommunityId());
        wrapper.between(ArrayUtils.isNotEmpty(query.getCreateTime()), NoticeEntity::getCreateTime, ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[0] : null, ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[1] : null);
        return wrapper;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(NoticeVO vo) {

        NoticeEntity entity = NoticeConvert.INSTANCE.convert(vo);
        entity.setPublishTime(vo.getPublishTime());
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(NoticeVO vo) {
        NoticeEntity entity = NoticeConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        removeBatchByIds(ids);
    }


}
