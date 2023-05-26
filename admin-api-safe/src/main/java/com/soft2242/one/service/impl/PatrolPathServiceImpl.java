package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.*;
import com.soft2242.one.dao.*;
import com.soft2242.one.entity.*;
import com.soft2242.one.query.PatrolPathQuery;
import com.soft2242.one.query.PatrolPointsQuery;
import com.soft2242.one.service.PatrolPathService;
import com.soft2242.one.vo.*;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 巡更路线表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class PatrolPathServiceImpl extends BaseServiceImpl<PatrolPathDao, PatrolPathEntity> implements PatrolPathService {

    @Override
    public PageResult<PatrolPathVO> page(PatrolPathQuery query) {
        Map<String, Object> params = getParams(query);
        IPage<PatrolPathEntity> page = getPage(query);
        params.put("page",page);
        List<PatrolPathVO> pathList = baseMapper.getPathList(params);
        return new PageResult<>(pathList, page.getTotal());
    }


    private Map<String,Object> getParams(PatrolPathQuery query){
        Map<String,Object> parmas=new HashMap<>();
        parmas.put("communityId",query.getCommunityId());
        return parmas;
    }
//    private LambdaQueryWrapper<PatrolPathEntity> getWrapper(PatrolPathQuery query){
//        LambdaQueryWrapper<PatrolPathEntity> wrapper = Wrappers.lambdaQuery();
//        if (query.getCommunityId()!=null) {
//            wrapper.eq(StringUtils.isNotEmpty(String.valueOf(query.getCommunityId())), PatrolPathEntity::getCommunityId, query.getCommunityId());
//        }
//        return wrapper;
//    }

    @Override
    public void save(PatrolPathVO vo) {
        PatrolPathEntity entity = PatrolPathConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Resource
    private CommunityDao dao;
    @Override
    public  List<CommunityVO> searchCommunity() {
        List<Community> communities = dao.selectList(null);
        List<CommunityVO> communityVOS = CommunityConvert.INSTANCE.convertList(communities);
        return  communityVOS;
    }

    @Resource
    PatrolPointsDao patrolPointsDao;
    @Override
    public List<PatrolPointsVO> searchPoints() {
        List<PatrolPointsEntity> patrolPointsEntities = patrolPointsDao.selectList(null);
        List<PatrolPointsVO> patrolPointsVOS = PatrolPointsConvert.INSTANCE.convertList(patrolPointsEntities);
        return patrolPointsVOS;
    }

    @Resource
    InspectionItemDao inspectionItemDao;

    @Override
    public List<InspectionItemVO> searchItems() {
        List<InspectionItemEntity> inspectionItemEntities = inspectionItemDao.selectList(null);
        List<InspectionItemVO> inspectionItemVOS = InspectionItemEntityConvert.INSTANCE.convertList(inspectionItemEntities);
        return inspectionItemVOS;
    }

    @Override
    public void update(PatrolPathVO vo) {
        PatrolPathEntity entity = PatrolPathConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}