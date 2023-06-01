package com.soft2242.one.task;

import com.soft2242.one.base.common.utils.DateUtils;
import com.soft2242.one.entity.PatrolPlanEntity;
import com.soft2242.one.entity.PatrolRecordsEntity;
import com.soft2242.one.service.InspectionItemPathService;
import com.soft2242.one.service.PatrolPathService;
import com.soft2242.one.service.PatrolRecordsService;
import com.soft2242.one.service.PointsPathService;
import com.soft2242.one.service.impl.PatrolPlanServiceImpl;
import com.soft2242.one.vo.PatrolPathVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanTask {
    @Autowired
    private PatrolPlanServiceImpl planService;
    @Autowired
    private PatrolPathService pathService;
    @Autowired
    private PointsPathService pointsPathService;
    @Autowired
    private InspectionItemPathService inspectionItemPathService;
    @Autowired
    private PatrolRecordsService recordsService;

    //一个月的时间毫秒数
    public static final long MONTH=1000*60*60*24*30;
    //一周的时间毫秒数
    public static final long WEEK=1000*60*60*24*7;
    //一天的时间毫秒数
    public static final long DAY=1000*60*60*24;

    @Scheduled(cron = "0 0 0-6 * * ?")
    public void generatedRecords(){
        //获取定时任务执行时的日期时间
        Date today=new Date();
        String dateString= DateUtils.format(today,DateUtils.DATE_TIME_PATTERN);

        //获取计划表中合适的数据
        //找到开始日期小于当前日期的计划
        List<PatrolPlanEntity> planList = planService.getPlanList(dateString);
        for (PatrolPlanEntity entity : planList){
            //判断时间间隔是否满足周期
            long flag= today.getTime() - entity.getLastTime().getTime();
            //判断计划的周期
            if(entity.getPlanCycle()==0){//周期每天
                if (flag>=DAY) {//满足时间间隔
                    //在记录表中生成记录
                    Inserinto(entity);
                    //记录添加完成后需要修改计划表中的上次执行时间
                    entity.setLastTime(today);
                    planService.updateById(entity);
                }
            }
            else if(entity.getPlanCycle()==1){//周期每星期
                if (flag>=WEEK) {//满足时间间隔
                    //在记录表中生成记录
                    Inserinto(entity);
                    //记录添加完成后需要修改计划表中的上次执行时间
                    entity.setLastTime(today);
                    planService.updateById(entity);
                }
            }
            else if (entity.getPlanCycle()==2) {//周期每月
                if (flag>=MONTH) {//满足时间间隔
                    //在记录表中生成记录
                    Inserinto(entity);
                    //记录添加完成后需要修改计划表中的上次执行时间
                    entity.setLastTime(today);
                    planService.updateById(entity);
                }
            }
        }

    }


    public void Inserinto(PatrolPlanEntity entity){
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
                    record.setStatus(0);
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
                    record.setStatus(0);
                    return record;
                }).collect(Collectors.toList());
                recordsService.saveBatch(recordsEntities);
            }
    }
}

