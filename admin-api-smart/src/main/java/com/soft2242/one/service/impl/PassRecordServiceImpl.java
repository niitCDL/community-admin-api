package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.dao.PassRecordDao;
import com.soft2242.one.entity.PassRecordEntity;
import com.soft2242.one.query.PassRecordQuery;
import com.soft2242.one.service.PassRecordService;
import com.soft2242.one.vo.PassRecordVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 通行记录
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
@Service
@AllArgsConstructor
public class PassRecordServiceImpl extends BaseServiceImpl<PassRecordDao, PassRecordEntity> implements PassRecordService {

    @Override
    public PageResult<PassRecordVO> page(PassRecordQuery query) {
        IPage<PassRecordEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(baseMapper.selectPageByQuery(query), page.getTotal());
    }

    private LambdaQueryWrapper<PassRecordEntity> getWrapper(PassRecordQuery query){
        LambdaQueryWrapper<PassRecordEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(query.getDoorId() != null, PassRecordEntity::getDoorId, query.getDoorId());
        wrapper.eq(query.getPassWay() != null, PassRecordEntity::getPassWay, query.getPassWay());
        wrapper.eq(query.getCommunityId() != null, PassRecordEntity::getCommunityId, query.getCommunityId());
        return wrapper;
    }

}