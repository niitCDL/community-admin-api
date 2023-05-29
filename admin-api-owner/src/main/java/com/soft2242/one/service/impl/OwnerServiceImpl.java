package com.soft2242.one.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import com.soft2242.one.convert.OwnerConvert;
import com.soft2242.one.entity.OwnerEntity;
import com.soft2242.one.query.OwnerQuery;
import com.soft2242.one.vo.OwnerVO;
import com.soft2242.one.dao.OwnerDao;
import com.soft2242.one.service.OwnerService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 业主表
 *
 * @author lsc lsc666@qq.com
 * @since 1.0.0 2023-05-28
 */
@Service
@AllArgsConstructor
public class OwnerServiceImpl extends BaseServiceImpl<OwnerDao, OwnerEntity> implements OwnerService {


    @Override
    public PageResult<OwnerVO> page(OwnerQuery query) {
        query.setStart((query.getPage()-1) * query.getLimit());
        return new PageResult<>(baseMapper.findOwnerOQ(query), baseMapper.findOwnerRecordByOQ(query));
    }

    private LambdaQueryWrapper<OwnerEntity> getWrapper(OwnerQuery query){
        LambdaQueryWrapper<OwnerEntity> wrapper = Wrappers.lambdaQuery();
        return wrapper;
    }

    @Override
    public void save(OwnerVO vo) {
        OwnerEntity entity = OwnerConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(OwnerVO vo) {
        OwnerEntity entity = OwnerConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}