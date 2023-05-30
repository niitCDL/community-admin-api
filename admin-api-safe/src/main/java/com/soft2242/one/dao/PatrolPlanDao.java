package com.soft2242.one.dao;


import com.soft2242.one.base.mybatis.dao.BaseDao;
import com.soft2242.one.entity.PatrolPlanEntity;
import com.soft2242.one.vo.PatrolPlanVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
* 巡更计划表
*
* @author litao soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Mapper
public interface PatrolPlanDao extends BaseDao<PatrolPlanEntity> {
    /**
     *根据条件查询巡更计划
     *return List<SysUserEntity>
     * */
    List<PatrolPlanVO> getPlanList(Map<String,Object> params);

    /**
     * 获取开始日期打到条件的计划
     * @param Date
     * @return
     */
    @Select("SELECT * from t_patrol_plan WHERE plan_start < #{date} AND status = 1 AND deleted = 0")
    List<PatrolPlanEntity> getFitPlan(@Param("date") String Date);
}