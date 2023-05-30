package com.soft2242.one.service;



import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.InspectionItemEntity;
import com.soft2242.one.query.InspectionItemQuery;
import com.soft2242.one.vo.InspectionItemVO;

import java.util.List;

/**
 * 巡检项目
 *
 * @author litao soft2242@gmail.com
 * @since 1.0.0 2023-05-25
 */
public interface InspectionItemService extends BaseService<InspectionItemEntity> {

    PageResult<InspectionItemVO> page(InspectionItemQuery query);

    void save(InspectionItemVO vo);

    void update(InspectionItemVO vo);

    void delete(List<Long> idList);

    void deleteByCommunityId(Long communityId);


}