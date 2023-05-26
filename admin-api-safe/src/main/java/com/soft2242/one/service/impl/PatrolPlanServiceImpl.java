package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.PatrolPlanConvert;
import com.soft2242.one.dao.PatrolPlanDao;
import com.soft2242.one.entity.PatrolPlanEntity;
import com.soft2242.one.query.PatrolPlanQuery;
import com.soft2242.one.service.PatrolPlanService;
import com.soft2242.one.vo.PatrolPlanVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 巡更计划表
 *
 * @author litao soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class PatrolPlanServiceImpl extends BaseServiceImpl<PatrolPlanDao, PatrolPlanEntity> implements PatrolPlanService {

    @Override
    public PageResult<PatrolPlanVO> page(PatrolPlanQuery query) {
//        IPage<PatrolPlanEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
//        List<PatrolPlanEntity> records = page.getRecords();

//        return new PageResult<>(PatrolPlanConvert.INSTANCE.convertList(records), page.getTotal());
        Map<String, Object> params = getParams(query);
        IPage<PatrolPlanEntity> page = getPage(query);
        params.put("page",page);
        List<PatrolPlanVO> planList = baseMapper.getPlanList(params);
        return new PageResult<>(planList, page.getTotal());
    }

//    private LambdaQueryWrapper<PatrolPlanEntity> getWrapper(PatrolPlanQuery query){
//        LambdaQueryWrapper<PatrolPlanEntity> wrapper = Wrappers.lambdaQuery();
//        wrapper.like(StringUtils.isNotEmpty(query.getCommunityName()), PatrolPlanEntity::getCommunityName, query.getCommunityName());
//        wrapper.like(StringUtils.isNotEmpty(query.getPlanName()), PatrolPlanEntity::getPlanName, query.getPlanName());
//        return wrapper;
//    }

    private Map<String,Object> getParams(PatrolPlanQuery query){
        Map<String,Object> parmas=new HashMap<>();
        parmas.put("communityName",query.getCommunityName());
        parmas.put("planName",query.getPlanName());
        parmas.put("name",query.getName());
        return parmas;
    }
    @Override
    public void save(PatrolPlanVO vo) {
        PatrolPlanEntity entity = PatrolPlanConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }
    @Override
    public void update(PatrolPlanVO vo) {
        PatrolPlanEntity entity = PatrolPlanConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public void deleteByCommunityId(Long communityId) {
        remove(new LambdaQueryWrapper<PatrolPlanEntity>().eq(PatrolPlanEntity::getCommunityId,communityId));
    }

}