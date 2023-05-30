package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.CommunityConvert;
import com.soft2242.one.convert.InspectionItemEntityConvert;
import com.soft2242.one.convert.PatrolPathConvert;
import com.soft2242.one.convert.PatrolPointsConvert;
import com.soft2242.one.dao.*;
import com.soft2242.one.entity.Community;
import com.soft2242.one.entity.InspectionItemEntity;
import com.soft2242.one.entity.PatrolPathEntity;
import com.soft2242.one.entity.PatrolPointsEntity;
import com.soft2242.one.query.PatrolPathQuery;
import com.soft2242.one.service.InspectionItemPathService;
import com.soft2242.one.service.PatrolPathService;
import com.soft2242.one.service.PointsPathService;
import com.soft2242.one.vo.*;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private PointsPathService pointsPathService;
    private InspectionItemPathService inspectionItemPathService;
    private PointsPathDao pointsPathDao;
    private PatrolPathDao patrolPathDao;
    private InspectionItemDao inspectionItemDao;

    @Autowired
    private CommunityServiceImpl serviceImpl;


    @Override
    public PageResult<PatrolPathVO> page(PatrolPathQuery query) {
        Map<String, Object> params = getParams(query);
        IPage<PatrolPathEntity> page = getPage(query);
        params.put("page", page);
        List<PatrolPathVO> pathList = baseMapper.getPathList(params);
        System.out.println("s--------------------------------" + pathList);
        return new PageResult<>(pathList, page.getTotal());


    }


    private Map<String, Object> getParams(PatrolPathQuery query) {
        Map<String, Object> parmas = new HashMap<>();
        parmas.put("communityIds", query.getCommunityIds());
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
        if (entity.getType() == 0) {
            pointsPathService.saveOrUpdate(vo.getElementIds(), entity.getId());
        }
        if (vo.getType() == 1) {
            inspectionItemPathService.saveOrUpdate(vo.getElementIds(), entity.getId());
        }

    }


    @Override
    public PatrolPathVO getPathById(Long id) {

        PatrolPathEntity path = this.getById(id);
        PatrolPathVO vo = PatrolPathConvert.INSTANCE.convert(path);


        if (path.getType() == 0) {
            List<Long> pointIdList = pointsPathService.getPointIdList(path.getId());
            System.out.println("---------------------------------------" + pointIdList);

//            List<PatrolPointsEntity> patrolPointsEntities = patrolPointsDao.selectBatchIds(pointIdList);

            vo.setElementIds(pointIdList);


        }
        if (path.getType() == 1) {
            List<Long> inspectionItemIdList = inspectionItemPathService.getInspectionItemIdList(path.getId());
            System.out.println("---------------------------------------" + inspectionItemIdList);
//            List<InspectionItemEntity> inspectionItemEntities = inspectionItemDao.selectBatchIds(inspectionItemIdList);
            vo.setElementIds(inspectionItemIdList);
        }

        return vo;

    }

    @Resource
    private CommunityDao dao;

    @Override
    public List<CommunityVO> searchCommunity() {
        List<Community> communities = dao.selectList(null);
        List<CommunityVO> communityVOS = CommunityConvert.INSTANCE.convertList(communities);
        return communityVOS;
    }

    @Resource
    PatrolPointsDao patrolPointsDao;

    @Override
    public List<PatrolPointsVO> searchPoints(Long communityId) {
        List<PatrolPointsEntity> patrolPointsEntities = patrolPointsDao.getByCommuntiyId(communityId);
        List<PatrolPointsVO> patrolPointsVOS = PatrolPointsConvert.INSTANCE.convertList(patrolPointsEntities);
        return patrolPointsVOS;
    }


    @Override
    public List<InspectionItemVO> searchItems(Long communityId) {
        List<InspectionItemEntity> inspectionItemEntities = inspectionItemDao.getByCommunityId(communityId);
        List<InspectionItemVO> inspectionItemVOS = InspectionItemEntityConvert.INSTANCE.convertList(inspectionItemEntities);
        return inspectionItemVOS;
    }


    @Override
    public void update(PatrolPathVO vo) {
        PatrolPathEntity entity = PatrolPathConvert.INSTANCE.convert(vo);
        updateById(entity);
         if (entity.getType()==0){
             pointsPathService.saveOrUpdate(vo.getElementIds(),entity.getId());
         }
         if (entity.getType()==1){
             inspectionItemPathService.saveOrUpdate(vo.getElementIds(),entity.getId());
         }

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {




    }


    @Override
    public List<PatrolPathVO> getPathListByCommId(Long commId) {
        Map<String, Object> map = new HashMap<>();
        map.put("community_id", commId);
        List<PatrolPathEntity> patrolPathEntities = baseMapper.selectByMap(map);
        return PatrolPathConvert.INSTANCE.convertList(patrolPathEntities);
    }

    @Override
    public List<ComAndPathVO> getCommAndPath() {

        List<ComAndPathVO> lists = new ArrayList<>();

        //先查询出所有的小区
        List<CommunityVO> list = serviceImpl.getList();
        //根据小区id查询出该小区的所有巡更路线
        for (CommunityVO vo : list) {
            ComAndPathVO comAndPathVO = new ComAndPathVO();
            comAndPathVO.setCommunityId(vo.getId());
            comAndPathVO.setCommunityName(vo.getCommunityName());
            List<PatrolPathVO> pathentitys = baseMapper.getPathListByCommunityId(vo.getId());
            comAndPathVO.setPatrolPathVO(pathentitys);
            lists.add(comAndPathVO);
        }

        return lists;
    }





}