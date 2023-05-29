package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.CommunityConvert;
import com.soft2242.one.convert.PatrolPointsConvert;
import com.soft2242.one.dao.CommunityDao;
import com.soft2242.one.dao.PatrolPointsDao;
import com.soft2242.one.entity.Community;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.query.PatrolPointsQuery;
import com.soft2242.one.service.PatrolPointsService;
import com.soft2242.one.vo.CommunityVO;
import com.soft2242.one.vo.PatrolPointsVO;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 巡更点表
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class PatrolPointsServiceImpl extends BaseServiceImpl<PatrolPointsDao, PatrolPointsEntity> implements PatrolPointsService {

    @Override
    public PageResult<PatrolPointsVO> page(PatrolPointsQuery query) {
        Map<String, Object> params = getParams(query);
        IPage<PatrolPointsEntity> page = getPage(query);
        params.put("page",page);
        List<PatrolPointsVO> pointsList = baseMapper.getPointsList(params);
        return new PageResult<>(pointsList, page.getTotal());
    }

//    private LambdaQueryWrapper<PatrolPointsEntity> getWrapper(PatrolPointsQuery query){
//        LambdaQueryWrapper<PatrolPointsEntity> wrapper = Wrappers.lambdaQuery();
//        if (query.getCommunityId()!=null) {
//            wrapper.eq(StringUtils.isNotEmpty(String.valueOf(query.getCommunityId())), PatrolPointsEntity::getId, query.getCommunityId());
//        }
//
//        return wrapper;
//    }

//    private Map<String,Object> getParams(PatrolPointsQuery query){
//        Map<String,Object> parmas=new HashMap<>();
//        parmas.put("communityId",query.getCommunityId());
//        return parmas;
//    }


    private Map<String,Object> getParams(PatrolPointsQuery query){
        Map<String,Object> parmas=new HashMap<>();
        parmas.put("communityIds",query.getCommunityIds());
        return parmas;
    }

    @Override
    public void save(PatrolPointsVO vo) {
        PatrolPointsEntity entity = PatrolPointsConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Resource
    private  CommunityDao dao;
    @Override
    public  List<CommunityVO> searchCommunity() {
        List<Community> communities = dao.selectList(null);
        List<CommunityVO> communityVOS = CommunityConvert.INSTANCE.convertList(communities);
        return  communityVOS;
    }

    @Resource
    PatrolPointsDao patrolPointsDao;
    @Override
    public PatrolPointsVO getById(Long id) {
        PatrolPointsVO byId = patrolPointsDao.getById(id);
        return byId;
    }

    @Override
    public void update(PatrolPointsVO vo) {
        PatrolPointsEntity entity = PatrolPointsConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}