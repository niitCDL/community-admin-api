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
import com.soft2242.one.query.NoticeQuery;
import com.soft2242.one.query.RepairQuery;
import com.soft2242.one.service.NoticeService;
import com.soft2242.one.vo.NoticeVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/24 9:14
 */
@Service
@AllArgsConstructor
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {

    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
        IPage<NoticeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(NoticeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<NoticeEntity> getWrapper(NoticeQuery query){
        LambdaQueryWrapper<NoticeEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StringUtils.isNotEmpty(query.getTitle()), NoticeEntity::getTitle, query.getTitle());
        wrapper.in(ArrayUtils.isNotEmpty(query.getCommunityId()) ,NoticeEntity::getCommunityId, query.getCommunityId());
        wrapper.between(ArrayUtils.isNotEmpty(query.getCreateTime()), NoticeEntity::getCreateTime, ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[0] : null, ArrayUtils.isNotEmpty(query.getCreateTime()) ? query.getCreateTime()[1] : null);

        return wrapper;
    }

//    private Map<String, Object> getParams(NoticeQuery query) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("title", query.getTitle());
//        params.put("content", query.getContent());
//        params.put("communityId", query.getCommunityId());
//        params.put("adminId", query.getAdminId());
//
//        // 数据权限
////        params.put(Constant.DATA_SCOPE, getDataScope("t1", null));
//
//        return params;
//    }

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
