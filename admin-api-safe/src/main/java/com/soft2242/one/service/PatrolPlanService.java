package com.soft2242.one.service;



import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.PatrolPlanEntity;
import com.soft2242.one.query.PatrolPlanQuery;
import com.soft2242.one.vo.PatrolPlanVO;

import java.util.List;

/**
 * 巡更计划表
 *
 * @author litao soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface PatrolPlanService extends BaseService<PatrolPlanEntity> {

    /**
     * 分页查询巡更计划
     * @param query
     * @return
     */
    PageResult<PatrolPlanVO> page(PatrolPlanQuery query);

    /**
     * 保存
     * @param vo
     */
    void save(PatrolPlanVO vo);

    /**
     * 修改
     * @param vo
     */
    void update(PatrolPlanVO vo);

    /**
     * 删除
     * @param idList
     */
    void delete(List<Long> idList);

    /**
     * 更具小区id删除巡更计划
     * @param communityId
     */
    void deleteByCommunityId(Long communityId);

    /**
     * 获取开始日期打到条件的计划
     * @param Date 日期
     * @return
     */
    List<PatrolPlanEntity> getPlanList(String Date);
}