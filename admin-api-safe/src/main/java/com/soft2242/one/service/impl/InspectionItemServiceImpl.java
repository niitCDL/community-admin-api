package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.InspectionItemEntityConvert;
import com.soft2242.one.dao.InspectionItemDao;
import com.soft2242.one.entity.InspectionItemEntity;
import com.soft2242.one.query.InspectionItemQuery;
import com.soft2242.one.service.InspectionItemService;
import com.soft2242.one.vo.InspectionItemVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 巡检项目
 *
 * @author litao soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class InspectionItemServiceImpl extends BaseServiceImpl<InspectionItemDao, InspectionItemEntity> implements InspectionItemService {


    @Override
    public PageResult<InspectionItemVO> page(InspectionItemQuery query) {
        IPage<InspectionItemEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(InspectionItemEntityConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<InspectionItemEntity> getWrapper(InspectionItemQuery query){
        LambdaQueryWrapper<InspectionItemEntity> wrapper = Wrappers.lambdaQuery();
//      wrapper.eq(StringUtils.isNotEmpty(query.ge), InspectionItemEntity::getCommunityId, query.getCommunityId());
        wrapper.like(StringUtils.isNotEmpty(query.getCommunityName()), InspectionItemEntity::getCommunityName, query.getCommunityName());
        wrapper.like(StringUtils.isNotEmpty(query.getName()), InspectionItemEntity::getName, query.getName());
        return wrapper;
    }

    @Override
    public void save(InspectionItemVO vo) {
        InspectionItemEntity entity = InspectionItemEntityConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }


    @Override
    public void update(InspectionItemVO vo) {
        InspectionItemEntity entity = InspectionItemEntityConvert.INSTANCE.convert(vo);
        updateById(entity);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    /**
     * 根据小区id，删除该小区的巡检项目
     * @param communityId
     */
    @Override
    public void deleteByCommunityId(Long communityId) {
        remove(new LambdaQueryWrapper<InspectionItemEntity>().eq(InspectionItemEntity::getCommunityId,communityId));
    }

}