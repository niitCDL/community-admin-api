package com.soft2242.one.service;

import com.soft2242.one.base.common.utils.PageResult;
import com.soft2242.one.base.mybatis.service.BaseService;
import com.soft2242.one.entity.Carport;
import com.soft2242.one.entity.ParkRecord;
import com.soft2242.one.query.ParkQuery;
import com.soft2242.one.query.ParkRecordQuery;
import com.soft2242.one.vo.ParkRecordVO;
import com.soft2242.one.vo.ParkVO;

import java.util.List;

/**
 * @ClassName ParkRecordService
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/30 08:56
 */
public interface ParkRecordService extends BaseService<ParkRecord> {
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<ParkRecordVO> page(ParkRecordQuery query);

    /**
     * 获取所有停车记录数据
     *
     * @return list
     */
    List<ParkRecordVO> getList();
}
