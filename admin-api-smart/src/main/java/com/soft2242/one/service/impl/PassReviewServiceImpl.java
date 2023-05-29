package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.PassReviewConvert;
import com.soft2242.one.dao.PassReviewDao;
import com.soft2242.one.entity.PassReviewEntity;
import com.soft2242.one.query.PassReviewQuery;
import com.soft2242.one.service.PassReviewService;
import com.soft2242.one.vo.PassReviewVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 门禁审核
 *
 * @author Flobby 
 * @since 1.0.0 2023-05-29
 */
@Service
@AllArgsConstructor
public class PassReviewServiceImpl extends BaseServiceImpl<PassReviewDao, PassReviewEntity> implements PassReviewService {

    @Override
    public PageResult<PassReviewVO> page(PassReviewQuery query) {
        IPage<PassReviewEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(baseMapper.selectPageByQuery(query), page.getTotal());
    }

    private LambdaQueryWrapper<PassReviewEntity> getWrapper(PassReviewQuery query){
        LambdaQueryWrapper<PassReviewEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(query.getStatus() != null, PassReviewEntity::getStatus, query.getStatus());
        return wrapper;
    }

    @Override
    public void save(PassReviewVO vo) {
        PassReviewEntity entity = PassReviewConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(PassReviewVO vo) {
        PassReviewEntity entity = PassReviewConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}