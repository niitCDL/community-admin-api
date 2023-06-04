package com.soft2242.one.service;



import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.RepairRecordEntity;
import com.soft2242.one.query.RepairRecordQuery;
import com.soft2242.one.vo.RepairRecordVO;

import java.util.HashMap;
import java.util.List;

/**
 * 报修处理表
 *
 * @author xuelong
 * @since 1.0.0 2023-06-04
 */
public interface RepairRecordService extends BaseService<RepairRecordEntity> {

    PageResult<RepairRecordVO> page(RepairRecordQuery query);

    void save(RepairRecordVO vo);
    void sOrUOrD(HashMap<String,Object> params);


    void update(RepairRecordVO vo);

    void delete(List<Long> idList);
}
