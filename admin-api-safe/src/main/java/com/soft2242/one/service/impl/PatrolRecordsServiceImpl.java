package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.PatrolRecordsConvert;
import com.soft2242.one.dao.PatrolRecordsDao;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.query.PatrolPointsQuery;
import com.soft2242.one.query.PatrolRecordsQuery;
import com.soft2242.one.service.PatrolRecordsService;
import com.soft2242.one.vo.PatrolPointsVO;
import com.soft2242.one.vo.PatrolRecordsVO;
import lombok.AllArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 巡更记录表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class PatrolRecordsServiceImpl extends BaseServiceImpl<PatrolRecordsDao, PatrolRecordsEntity> implements PatrolRecordsService {

    @Override
    public PageResult<PatrolRecordsVO> page(PatrolRecordsQuery query) {
        Map<String, Object> params = getParams(query);
        IPage<PatrolRecordsEntity> page = getPage(query);
        params.put("page",page);
        List<PatrolRecordsVO> recordsVOS = baseMapper.searchList(params);
        return new PageResult<>(recordsVOS, page.getTotal());

    }

    private Map<String,Object> getParams(PatrolRecordsQuery query){
        Map<String,Object> parmas=new HashMap<>();
        parmas.put("id",query.getPointId());
        return parmas;
    }

//    private LambdaQueryWrapper<PatrolRecordsEntity> getWrapper(PatrolRecordsQuery query){
//        LambdaQueryWrapper<PatrolRecordsEntity> wrapper = Wrappers.lambdaQuery();
//        if (query.getPointId()!=null) {
//            wrapper.eq(StringUtils.isNotEmpty(query.getPointId().toString()), PatrolRecordsEntity::getPointId, query.getPointId());
//        }
//        return wrapper;
//    }

    @Override
    public void save(PatrolRecordsVO vo) {
        PatrolRecordsEntity entity = PatrolRecordsConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(PatrolRecordsVO vo) {
        PatrolRecordsEntity entity = PatrolRecordsConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}