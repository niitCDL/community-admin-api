package com.soft2242.one.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.impl.BaseServiceImpl;
import com.soft2242.one.convert.PatrolPlanConvert;
import com.soft2242.one.dao.PatrolPlanDao;
import com.soft2242.one.entity.PatrolPlanEntity;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.query.PatrolPlanQuery;
import com.soft2242.one.service.*;
import com.soft2242.one.vo.PatrolPathVO;
import com.soft2242.one.vo.PatrolPlanVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 巡更计划表
 *
 * @author litao soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
@Service
@AllArgsConstructor
public class PatrolPlanServiceImpl extends BaseServiceImpl<PatrolPlanDao, PatrolPlanEntity> implements PatrolPlanService {
    private PatrolPathService pathService;
    private PointsPathService pointsPathService;
    private InspectionItemPathService inspectionItemPathService;
    private PatrolRecordsService recordsService;
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
        parmas.put("communityId",query.getCommunityId());
        parmas.put("planName",query.getPlanName());
        parmas.put("name",query.getName());
        return parmas;
    }
    @Override
    public void save(PatrolPlanVO vo) {
        PatrolPlanEntity entity = PatrolPlanConvert.INSTANCE.convert(vo);
        //在新添加计划时，默认上次执行时间时当前时间
        entity.setLastTime(entity.getPlanStart());
        baseMapper.insert(entity);
        checkPlan(entity);
    }

    public void checkPlan(PatrolPlanEntity entity){
        Date date=new Date();
        //当新增计划成功时，判断当前计划是否此时需要执行
        if(entity.getPlanStart().getTime()<date.getTime()){
            //如果周期是每天，需要立即添加巡更记录
//            if(entity.getPlanCycle()==0){
                //先查找此计划线路的所有巡检点
                PatrolPathVO path = pathService.getPathById(entity.getPathId());
                //判断当前的线路是什么类型
                if(path.getType()==0){//巡更点类型
                    //找出此线路的所有点
                    List<Long> pointIdList = pointsPathService.getPointIdList(path.getId());
                    List<PatrolRecordsEntity> recordsEntities=pointIdList.stream().map(pointid->{
                        PatrolRecordsEntity record=new PatrolRecordsEntity();
                        record.setPathId(path.getId());
                        record.setPlanId(entity.getId());
                        record.setInspectorId(entity.getInspectorId());
                        record.setPointId(pointid);
                        record.setPhotoRequirement(entity.getPhotoRequirement());
                        record.setStatus(1);
                        return record;
                    }).collect(Collectors.toList());
                    recordsService.saveBatch(recordsEntities);
                }else {
                    //巡检项目类型
                    List<Long> inspectionItemIdList = inspectionItemPathService.getInspectionItemIdList(entity.getPathId());
                    List<PatrolRecordsEntity> recordsEntities=inspectionItemIdList.stream().map(pointid->{
                        PatrolRecordsEntity record=new PatrolRecordsEntity();
                        record.setPathId(path.getId());
                        record.setPlanId(entity.getId());
                        record.setInspectorId(entity.getInspectorId());
                        record.setPointId(pointid);
                        record.setPhotoRequirement(entity.getPhotoRequirement());
                        record.setStatus(1);
                        return record;
                    }).collect(Collectors.toList());
                    recordsService.saveBatch(recordsEntities);
                }

        }
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